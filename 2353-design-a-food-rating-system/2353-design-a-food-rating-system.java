class FoodRatings {
    private Map<String, Integer> foodToRating = new HashMap<>();
    private Map<String, String> foodToCuisine = new HashMap<>();
    private Map<String, TreeSet<String>> cuisineToFoods = new HashMap<>();
    
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for(int i = 0; i < foods.length; i++) {
            foodToRating.put(foods[i], ratings[i]);
            foodToCuisine.put(foods[i], cuisines[i]);
            
            // TreeSet with custom comparator
            cuisineToFoods.computeIfAbsent(cuisines[i], k -> 
                new TreeSet<>((a, b) -> {
                    int ratingA = foodToRating.get(a);
                    int ratingB = foodToRating.get(b);
                    
                    if(ratingA != ratingB) {
                        return ratingB - ratingA; // Higher rating first
                    }
                    return a.compareTo(b); // Lexicographic order
                })
            ).add(foods[i]);
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        
        // Remove, update, add back
        cuisineToFoods.get(cuisine).remove(food);
        foodToRating.put(food, newRating);
        cuisineToFoods.get(cuisine).add(food);
    }
    
    public String highestRated(String cuisine) {
        return cuisineToFoods.get(cuisine).first();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
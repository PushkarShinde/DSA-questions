class Solution {
    public int subarraySum(int[] nums, int k) {
        /**
        BRUTE APPROACH
        double for loop and sum of each substring
         */
        // OPTIMAL APPROACH
        int n=nums.length;
        HashMap<Integer, Integer> map=new HashMap<>();
        int count=0;
        map.put(0,1); // kyuki intially kuch liya nahi toh bas 0 sum hoga
        int sum=0;
        for(int num:nums){
            sum+=num;
            //sum-k agar mil gaya matlab ki K exist karta hai
            if(map.containsKey(sum-k)) count+=map.get(sum-k);
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
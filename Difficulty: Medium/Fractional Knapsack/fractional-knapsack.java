class Solution {
    
    class Items{
        int val;
        int wght;
        double ratio;
        Items(int val, int wght){
            this.val=val;
            this.wght=wght;
            this.ratio=(double)val/wght;
        }
    }
    
    double fractionalKnapsack(int[] values, int[] weights, int W) {
        int n=weights.length;
        List<Items> items=new ArrayList<>(); 
        // Collections.sort(map.keySet(), (a,b)->a-b);
        for(int i=0;i<n;i++){
            items.add(new Items(values[i], weights[i]));
        }
        items.sort((a,b)->Double.compare(b.ratio,a.ratio));
        double totalVal=0.0;
        for(Items item: items){
            if(item.wght<=W){
                W-=item.wght;
                totalVal+=item.val;
            }else{
                totalVal+=W*item.ratio;
                break;
            }
        }
        return totalVal;
    }
}
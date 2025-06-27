class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        long totalDays=m*k;
        if(n<totalDays) return -1;
        //BSA
        int left=Integer.MAX_VALUE;
        int right=Integer.MIN_VALUE;
        for(int i:bloomDay){
            left=Math.min(i,left);
            right=Math.max(i,right);
        }
        while(left<right){
            int mid=left+(right-left)/2;
            if(bouquete(bloomDay, m, k, mid)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    private boolean bouquete(int[] bloomDay, int m, int k, int day){
        int bouq=0, count=0;
        for(int d:bloomDay){
            if(d<=day){
                count++;
                if(count==k){
                    bouq++;
                    count=0;
                }
            }else{
                count=0;
            }
        }
        return bouq>=m;
    }
}
class Solution {
    public int countKdivPairs(int[] arr, int k) {
        int[] map=new int[k+1];
        
        int res=0;
        for(int i:arr){
            int rem=i%k;
            int req=rem==0?0:k-rem;
            
            res+=map[req];
            
            map[rem]++;
        }
        
        return res;
    }
}
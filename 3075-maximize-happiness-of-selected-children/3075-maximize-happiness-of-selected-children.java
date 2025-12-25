class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n=happiness.length;
        Arrays.sort(happiness);
        long ans=0L;
        int j=n-1;
        for(int i=0;i<k;i++){
            if(happiness[j]-i<=0) break;
            ans+=happiness[j]-i;
            j--;
        }
        return ans;
    }
}
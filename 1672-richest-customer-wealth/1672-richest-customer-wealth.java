class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxsum=sumele(accounts[0]);
        for(int[] a: accounts){
            if(maxsum<sumele(a)){
                maxsum=sumele(a);
            }
        }
        return maxsum;
    }
    public int sumele(int[] ar){
        int sum=0;
        for(int a: ar){
            sum+=a;
        }
        return sum;
    }
}
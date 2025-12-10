class Solution {
    private int mod=(int)1e9+7;
    public int countPermutations(int[] complexity) {
        int minNum=Integer.MAX_VALUE;
        for(int i:complexity){
            minNum=Math.min(minNum, i);
        }
        int countMin=0;
        for(int i: complexity){
            if(i==minNum) countMin++;
        }
        if(countMin>1) return 0;
        if(complexity[0]!=minNum) return 0;
        int n=complexity.length;
        long res=1;
        for(int i=n-1;i>=1;i--){
            res=(res*(long)i)%mod;
        }
        return (int)res;
    }
}
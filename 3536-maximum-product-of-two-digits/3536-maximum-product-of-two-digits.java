class Solution {
    public int maxProduct(int n) {
        int max=0, maxs=0;
        while(n>0){
            int d=n%10;
            if(max<d){
                maxs=max;
                max=d;
            }else if(maxs<d) maxs=d;

            n/=10;
        }

        return max*maxs;
    }
}
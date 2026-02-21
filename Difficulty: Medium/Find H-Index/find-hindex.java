class Solution {
    public int hIndex(int[] cit) {
        Arrays.sort(cit);
        int n=cit.length;
        int min=Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
            if(cit[i]<n-i) return n-i-1;
            else if(cit[i]==n-i) return cit[i];
        }
        return n;
    }
}
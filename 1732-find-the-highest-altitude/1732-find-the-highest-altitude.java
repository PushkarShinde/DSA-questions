class Solution {
    public int largestAltitude(int[] gain) {
        int maxSum=0;
        int sum=0;
        for(int g:gain){
            sum+=g;
            maxSum=Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
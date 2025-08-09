class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int total=0;
        for(int c: cardPoints){
            total+=c;
        }
        if(k==n) return total;
        int window=n-k;
        int windowSum=0;
        for(int i=0;i<window;i++){
            windowSum+=cardPoints[i];
        }
        int minWindowSum=windowSum;
        for(int i=window;i<n;i++){
            windowSum+=cardPoints[i]-cardPoints[i-window];
            minWindowSum=Math.min(minWindowSum, windowSum);
        }

        return total-minWindowSum;
    }
}
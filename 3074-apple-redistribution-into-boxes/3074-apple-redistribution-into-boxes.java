class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int n=apple.length;
        int m=capacity.length;
        int totalApple=0;
        for(int i=0;i<n;i++){
            totalApple+=apple[i];
        }
        Arrays.sort(capacity);
        int totalCap=0;
        int count=0;
        for(int i=m-1;i>=0;i--){
            totalCap+=capacity[i];
            count++;
            if(totalCap>=totalApple) break;
        }
        return count;
    }
}
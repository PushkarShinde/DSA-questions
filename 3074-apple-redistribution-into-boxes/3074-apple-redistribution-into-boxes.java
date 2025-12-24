class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int n=apple.length;
        int m=capacity.length;
        int totalApple=0;
        for(int i=0;i<n;i++){
            totalApple+=apple[i];
        }
        Arrays.sort(capacity);
        int count=0;
        for(int i=m-1;i>=0;i--){
            totalApple-=capacity[i];
            count++;
            if(totalApple<=0) break;
        }
        return count;
    }
}
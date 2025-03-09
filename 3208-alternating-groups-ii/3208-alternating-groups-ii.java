class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int count=0;
        int n=colors.length;
        int alternateCount=1; // Start from 1 since a single tile is always alternating
        for(int i=1;i<n+k-1;i++){
            if(colors[i%n]!=colors[(i-1)%n]){
                alternateCount++;
            }else{
                alternateCount=1;
            }
            if (i>=k-1 && alternateCount>=k) {
                count++;
            }
        }
        return count;
    }
}
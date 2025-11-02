class Solution {
    public int smallestNumber(int n) {
        int i=0;
        while(true){
            int num=(1<<i)-1;
            if(num>=n) return num;
            i++;
        }
    }
}
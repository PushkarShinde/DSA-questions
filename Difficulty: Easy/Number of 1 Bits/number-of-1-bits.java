// User function Template for Java
class Solution {
    static int setBits(int n) {
        int count=0;
        int i=1;
        while(i<=n){
            if((n&i)!=0) count++;
            i<<=1;
        }
        return count;
    }
}
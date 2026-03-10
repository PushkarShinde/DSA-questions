// User function Template for Java

class Solution {

    public int XOR(int n, int m) {
        return  n^m;
    }

    public int check(int a, int b) {
        if(((1<<(a-1))&b)!=0) return 1;
        return 0;
    }

    public int setBit(int c, int d) {
        return (1<<c) | d;
    }
}
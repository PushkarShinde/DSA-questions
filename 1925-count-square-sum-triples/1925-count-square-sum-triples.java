class Solution {
    public int countTriples(int n) {
        int count=0;
        for(int a=1;a<=n;a++){
            for(int b=1;b<=n;b++){
                int c1=a*a + b*b;
                int c2=(int)(Math.sqrt(c1));
                if(c2<=n && c2*c2==c1) count++;
            }
        }
        return count;
    }
}
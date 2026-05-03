class Solution {
    public boolean rotateString(String s, String goal) {
        int n=goal.length();
        int m=s.length();
        if(n!=m) return false;
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            boolean found=false;
            if(c==goal.charAt(0)){
                int j=0;
                for(;j<n;j++){
                    if(s.charAt((i+j)%n)!=goal.charAt(j)) break;
                }
                if(j==n) found=true;
            }
            if(found) return true;
        }
        return false;
    }
}
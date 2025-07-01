class Solution {
    public boolean rotateString(String s, String goal) {
        int m=s.length();
        int n=goal.length();
        if(n!=m) return false;
        return (s+s).contains(goal); // wow
    }
}
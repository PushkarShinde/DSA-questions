class Solution {
    public int minOperations(String s) {
        return Math.min(ops(s,1),ops(s,0));
    }
    char[] ch={'1','0'};
    private int ops(String s, int c){
        int n=s.length();
        int count=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)!=ch[(i+c)%2]) count++;
        }
        return count;
    }
}
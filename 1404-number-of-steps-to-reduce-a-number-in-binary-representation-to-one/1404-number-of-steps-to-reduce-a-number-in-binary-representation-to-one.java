class Solution {
    public int numSteps(String s) {
        int steps=0;
        int carry=0;
        int n=s.length();
        for(int i=n-1;i>=1;i--){
            int num=s.charAt(i)-'0';
            if(num+carry==1){
                steps+=2;
                carry=1;
            }else{
                steps++;
            }
        }
        return steps+carry;
    }
}
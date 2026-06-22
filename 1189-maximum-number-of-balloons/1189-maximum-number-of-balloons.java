class Solution {
    public int maxNumberOfBalloons(String text) {
        int n=text.length();
        
        char[] fre=new char[26];
        for(char c:text.toCharArray()){
            fre[c-'a']++;
        }

        char[] balloon={'b','a','l','o','n'};
        int res=(int)1e5;
        for(char c:balloon){
            if(c=='l' || c=='o') res=Math.min(res, fre[c-'a']/2);
            else res=Math.min(res, fre[c-'a']);
        }

        return res;
    }
}
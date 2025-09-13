class Solution {
    public int maxFreqSum(String s) {
        int[] ch=new int[26];
        for(char c: s.toCharArray()){
            ch[c-'a']++;
        }
        int maxV=0;
        int maxC=0;
        for(int i=0;i<26;i++){
            if(i=='a'-'a' || i=='e'-'a' || i=='i'-'a' || i=='o'-'a' || i=='u'-'a') maxV=Math.max(maxV,ch[i]);
            else{
                maxC=Math.max(maxC,ch[i]);
            }
        }
        return maxC+maxV;
    }
}
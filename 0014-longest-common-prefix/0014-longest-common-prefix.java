class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n=strs.length;
        if(n==0 || strs==null) return ""; 
        String res=strs[0];
        for(int i=1;i<n;i++){
            res=prefix(strs[i],res);
            if(res.isEmpty()) return "";
        }
        return res;
    }
    private String prefix(String str1, String str2){
        int n=str1.length();
        int m=str2.length();
        int len=Math.min(n,m);
        int i=0;
        while(i<len && str1.charAt(i)==str2.charAt(i)){
            i++;
        }
        return str1.substring(0,i);
    }
}
class Solution {
    public String largestGoodInteger(String num) {
        int n=num.length();
        int nu=0;
        String maxStr="";
        for(int i=0;i<n-2;i++){
            char c1=num.charAt(i);
            if(c1==num.charAt(i+1) && c1==num.charAt(i+2)){
                String string=num.substring(i,i+3);
                if(maxStr.equals("") || string.compareTo(maxStr)>0){
                    maxStr=string;
                }
            }
        }
        return maxStr;
    }
}
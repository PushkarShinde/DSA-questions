class Solution {
    public int getLastDigit(String a, String b) {
        boolean isZero = true;
        for(char c : b.toCharArray()){
            if(c!='0'){
                isZero = false;
                break;
            }
        }
        if(isZero) return 1;
        
        int[][] cycle={{0},{1},{2,4,8,6},{3,9,7,1},{4,6},{5},{6},{7,9,3,1},{8,4,2,6},{9,1}};
        int numA=a.charAt(a.length()-1)-'0';
        int len=cycle[numA].length;
        
        int mod=0;
        for(char c:b.toCharArray()){
            mod=(mod*10+(c-'0'))%len;
        }
        if(mod==0) mod=len;
        
        return cycle[numA][mod-1];
    }
};
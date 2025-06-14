class Solution {
    public int minMaxDifference(int num) {
        String str=Integer.toString(num);
        int n=str.length();
        char replaceMax=' ';
        for(char c: str.toCharArray()){
            if(c!='9'){
                replaceMax=c;
                break;
            }
        }
        String maxStr=str.replace(replaceMax,'9');
        int maxNum=Integer.parseInt(maxStr);

        char replaceMin=' ';
        for(char c: str.toCharArray()){
            if(c!='0'){
                replaceMin=c;
                break;
            }
        }
        String minStr=str.replace(replaceMin,'0');
        int minNum=Integer.parseInt(minStr);

        return maxNum-minNum;
    }
}
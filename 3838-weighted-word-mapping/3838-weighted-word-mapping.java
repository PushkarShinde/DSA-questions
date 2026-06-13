class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder res=new StringBuilder();
        for(String w:words){
            int sum=0;
            for(char c:w.toCharArray()){
                sum+=weights[c-'a'];
            }
            sum%=26;
            sum=26-sum;
            res.append((char)('a'+sum-1));
        }
        return res.toString();
    }
}
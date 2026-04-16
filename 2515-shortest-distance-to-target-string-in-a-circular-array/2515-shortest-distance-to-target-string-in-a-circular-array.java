class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n=words.length;
        int res=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            if(words[i].equals(target)){
                int d=Math.abs(i-startIndex);
                d=Math.min(d, n-d);
                res=Math.min(res, d);
            }
        }
        return res!=Integer.MAX_VALUE?res:-1;
    }
}
class Solution {
    public int minDeletionSize(String[] strs) {
        int n=strs.length;
        int count=0;
        int m=strs[0].length();
        for(int j=0;j<m;j++){
            for(int i=1;i<n;i++){
                int pre=strs[i-1].charAt(j)-'a';
                int cur=strs[i].charAt(j)-'a';
                if(pre>cur) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
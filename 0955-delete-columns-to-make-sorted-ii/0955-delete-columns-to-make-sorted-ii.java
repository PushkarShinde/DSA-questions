class Solution {
    public int minDeletionSize(String[] strs) {
        int n=strs.length;
        int count=0;
        int m=strs[0].length();
        boolean[] sorted=new boolean[n];
        sorted[0]=true;
        for(int j=0;j<m;j++){
            boolean deleted=false;
            for(int i=1;i<n;i++){
                if(!sorted[i] && strs[i - 1].charAt(j) > strs[i].charAt(j)){
                    deleted=true;
                    count++;
                    break;
                }
            }
            if(deleted) continue;

            for(int i=1;i<n;i++){
                if(strs[i - 1].charAt(j) < strs[i].charAt(j)){
                    sorted[i]=true;
                }
            }
        }
        return count;
    }
}
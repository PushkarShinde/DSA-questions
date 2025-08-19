class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n=g.length;
        int m=s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int count=0;
        for(int i=0;i<m;i++){
            if(i<n && g[i]<=s[i]){
                count++;
            }
            if(i==n) break;
        }
        return count;
    }
}
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n=g.length;
        int m=s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int count=0;
        int i=0, j=0;
        while(i<m && j<n){
            if(g[j]<=s[i]){
                count++;
                i++; j++;
            }else{
                i++;
            }
            // if(i==n) break;
        }
        return count;
    }
}
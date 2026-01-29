class Solution {
  private long INF=(long)1e18;
  long[][] dist;
  public long minimumCost(String source, String target, char[] original, 
                          char[] changed, int[] cost) {
    int n=source.length();
    int m=original.length;
    //FLOYD WARSHAL - ALL PAIR SHORTEST PATH
    dist=new long[26][26];
    for(int i=0;i<26;i++){
      Arrays.fill(dist[i], INF);
      dist[i][i]=0;
    }
    for(int i=0;i<m;i++){
      int u=(original[i]-'a');
      int v=(changed[i]-'a');
      dist[u][v]=Math.min(dist[u][v],cost[i]);
    }
    for(int k=0;k<26;k++){
      for(int i=0;i<26;i++){
        for(int j=0;j<26;j++){
          dist[i][j]=Math.min(dist[i][j], dist[i][k]+dist[k][j]);
        }
      }
    }
    long count=0;
    for(int i=0;i<n;i++){
      int s=source.charAt(i)-'a';
      int t=target.charAt(i)-'a';
      if(s!=t){
        if(dist[s][t]==INF) return -1;
        count+=dist[s][t];
      }
    }
    return count;
  }
}
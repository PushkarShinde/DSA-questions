class Solution {
    private int[][] pre;
    private int[][] suf;
    public int minFlips(String s) {
        /**
        Let pre[i][j] denote the minimum number of type 2 operations required to transform 
        the prefix s[0..i] into an alternating string ending with digit j, where j∈0,1.
        recurrence relation: 
        pre[i][0]=pre[i−1][1]+I(s[i],1)   
        pre[i][1]=pre[i−1][0]+I(s[i],0)
​        Here, I(x,y) is the indicator function, which equals 1 if x=y, and 0 otherwise.
        ...similarly suf[i][j] denote the minimum number of type 2 operations required to 
        transform the suffix s[i..n−1] into an alternating string starting with digit j.
        suf[i][0]=suf[i+1][1]+I(s[i],1)
        suf[i][1]=suf[i+1][0]+I(s[i],0)
        */
        
        int n=s.length();
        if(n==1) return 0;
        pre=new int[n][2];
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            pre[i][0]=(i==0?0:pre[i-1][1])+(c=='0'?0:1);
            pre[i][1]=(i==0?0:pre[i-1][0])+(c=='1'?0:1);
        }
        int minRes=Math.min(pre[n-1][1], pre[n-1][0]);
        if(n%2!=0){
            suf=new int[n][2];
            for(int i=n-1;i>=0;i--){
                char c=s.charAt(i);
                suf[i][0]=(i==n-1?0:suf[i+1][1])+(c=='0'?0:1);
                suf[i][1]=(i==n-1?0:suf[i+1][0])+(c=='1'?0:1);
            }
            for(int i=0;i<n-1;i++){
                minRes=Math.min(minRes, pre[i][1]+suf[i+1][1]);
                minRes=Math.min(minRes, pre[i][0]+suf[i+1][0]);
            }
        }
        return minRes;
    }
}
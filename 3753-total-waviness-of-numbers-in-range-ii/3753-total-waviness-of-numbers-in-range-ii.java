class Solution {
    String s;
    int n;
    long[][][][][][] dp;
    public long totalWaviness(long a, long b) {
        return func(b)-func(a-1);
    }

    private long func(long a){
        if (a < 100) return 0;
        s=Long.toString(a);
        n=s.length();

        dp= new long[n][11][11][2][2][2];
        for (long[][][][][] d1 : dp) {
            for (long[][][][] d2 : d1) {
                for (long[][][] d3 : d2) {
                    for (long[][] d4 : d3) {
                        for (long[] d5 : d4) {
                            Arrays.fill(d5, -1);
                        }
                    }
                }
            }
        }

        long[] res=solve(0,-1,-1,true,true);//[]={totalNumbers, totalWaveScore}
        return res[1];
    }

    private long[] solve(int i, int prepre, int pre, boolean islimit, boolean isleadingZero){
        if(i==n) return new long[]{1,0};

        int p2=prepre+1;
        int p1=pre+1;
        int lim=islimit?1:0;
        int lead=isleadingZero?1:0;

        if(dp[i][p2][p1][lim][lead][0]!=-1){
            return new long[]{
                dp[i][p2][p1][lim][lead][0], dp[i][p2][p1][lim][lead][1]
            };
        }

        long totalNumbers=0;
        long totalWaveScore=0;

        int digitLimit=islimit?s.charAt(i)-'0':9;

        for(int d=0;d<=digitLimit;d++){
            boolean newLeadingZero=isleadingZero && (d==0);
            int newprepre=pre;
            int newpre=newLeadingZero?-1:d;

            long[] remain=solve(i+1, newprepre, newpre, islimit && d==digitLimit, newLeadingZero);
            //{remainingTotalNumbers, remainingWaveScore}

            if(!newLeadingZero && prepre>=0 && pre>=0){
                boolean peak=d<pre && prepre<pre;
                boolean valley=d>pre && prepre>pre;

                if(peak || valley) totalWaveScore+=remain[0];
            }

            totalNumbers+=remain[0];
            totalWaveScore+=remain[1];
        }

        dp[i][p2][p1][lim][lead][0]=totalNumbers;
        dp[i][p2][p1][lim][lead][1]=totalWaveScore;

        return new long[]{totalNumbers, totalWaveScore};
    }
}
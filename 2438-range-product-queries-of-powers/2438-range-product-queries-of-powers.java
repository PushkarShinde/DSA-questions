class Solution {
    private static final int mod=(int)1e9+7;
    public int[] productQueries(int n, int[][] queries) {
        int m=queries.length;
        // int[] powers=new int[]
        List<Integer> powers = new ArrayList<>();
        int pos = 0;
        while (n > 0) {
            if ((n & 1) == 1) powers.add(1 << pos);
            pos++;
            n >>= 1;
        }
        Collections.sort(powers);
        int[] res=new int[m];
        for(int i=0;i<m;i++){
            int left=queries[i][0];
            int right=queries[i][1];
            long prod=1;
            for(int j=left;j<=right;j++){
                prod = (prod * powers.get(j)) % mod;
            }
            res[i]=(int)prod;
        }
        return res;
    }
}
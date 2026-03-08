class Solution {
    private String s;
    private int encCost;
    private int flatCost;
    private int[] pre;
    private Map<String, Long> map;
    public long minCost(String s, int encCost, int flatCost) {
        this.s = s;
        this.encCost = encCost;
        this.flatCost = flatCost;
        int n=s.length();
        map=new HashMap<>();
        pre=new int[n + 1];
        for (int i=0; i<n; i++) {
            pre[i+1]=pre[i]+(s.charAt(i)=='1'?1:0);
        }
        return solve(0,n);
    }

    private long solve(int x,int y){
        if(y<=x) return 0;
        int len=y-x;
        int ones=pre[y]-pre[x];

        String key=x+","+y;
        if(map.containsKey(key)) return map.get(key);

        long noSplitCost=0;
        if(ones==0) return noSplitCost=flatCost;
        else noSplitCost=(long)len*ones*encCost;

        long res=noSplitCost;
        if(len%2==0){
            int mid=x+(y-x)/2;
            long splitCost=solve(x,mid)+solve(mid,y);
            res=Math.min(res, splitCost);
        }

        map.put(key, res);

        return res;
    }
}
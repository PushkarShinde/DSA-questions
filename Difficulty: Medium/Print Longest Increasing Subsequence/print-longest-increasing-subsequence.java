class Solution {
     ArrayList<Integer> res;
     int[] arr;
     int n;
     int[] dp;
    public ArrayList<Integer> getLIS(int arr[]) {
        this.arr=arr;
        n=arr.length;
        res=new ArrayList<>();
        int n=arr.length;
        
        dp=new int[n];
        Arrays.fill(dp, 1);
        int[] hash=new int[n];
        int lis=1, lisInd=0;
        for(int i=0;i<n;i++){
            hash[i]=i;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    if(dp[i]<1+dp[j]){
                        dp[i]=1+dp[j];
                        hash[i]=j;
                    }
                }
            }
            if(dp[i]>lis){
                lis=dp[i];
                lisInd=i;
            }
        }
        res.add(arr[lisInd]);
        while(hash[lisInd]!=lisInd){
            lisInd=hash[lisInd];
            res.add(arr[lisInd]);
        }
        Collections.reverse(res);
        return res;
    }
}

class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n=nums.length;

        int minVal=Integer.MAX_VALUE;
        int maxVal=Integer.MIN_VALUE;
        int maxInd=0;
        int minInd=0;
        for(int i=0;i<n;i++){
            int num=nums[i];
            if(num<minVal){
                minVal=num;
                minInd=i;
            }
            if(num>maxVal){
                maxVal=num;
                maxInd=i;
            }
        }

        int left=Math.min(minInd, maxInd);
        int right=Math.max(minInd, maxInd);
        int possible=(left+1)*(n-right);
        if(k<=possible) return (long)k*(maxVal-minVal);
        
        //building sparse table
        int log=1;
        while((1<<log)<=n) log++;

        int[][] sparsemax=new int[n][log];
        int[][] sparsemin=new int[n][log];

        for(int i=0;i<n;i++){//window of size 1
            sparsemin[i][0]=nums[i];
            sparsemax[i][0]=nums[i];
        }

        for(int j=1;j<log;j++){
            for(int i=0; i+(1<<j)<=n; i++){
                sparsemin[i][j]=Math.min(
                    sparsemin[i][j-1], 
                    sparsemin[i+(1<<(j-1))][j-1]
                );
                sparsemax[i][j]=Math.max(
                    sparsemax[i][j-1], 
                    sparsemax[i+(1<<(j-1))][j-1]
                );
            }
        } 

        int[] log2=new int[n+1];
        log2[1]=0;
        for(int i=2;i<=n;i++){
            log2[i]=log2[i/2]+1;
        }

        PriorityQueue<long[]> pq=new PriorityQueue<>((x,y)->Long.compare(y[0],x[0]));
        for(int l=0;l<n;l++){
            long val=query(sparsemax, sparsemin, log2, l, n-1);
            pq.offer(new long[]{val, l,n-1});
        }

        long total=0;
        while(k-->0){
            long[] top=pq.poll();
            long val=top[0];
            int l=(int)top[1];
            int r=(int)top[2];
            total+=val;

            //shrink r by 1 (next in line)
            if(r>l){
                long nextVal=query(sparsemax, sparsemin, log2, l, r-1);
                pq.offer(new long[]{nextVal, l, r-1});
            }
        }

        return total;
    }

    private long query(int[][] max, int[][] min, int[] log, int l, int r){
        int len=r-l+1;
        int p=log[len];
        int range=1<<p;
        int maxVal=Math.max(max[l][p], max[r-range+1][p]);
        int minVal=Math.min(min[l][p], min[r-range+1][p]);

        return maxVal-minVal;
    }
}
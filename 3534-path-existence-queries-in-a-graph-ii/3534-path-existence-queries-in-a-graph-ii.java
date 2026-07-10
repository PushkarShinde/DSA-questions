class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries){
        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=nums[i];
            arr[i][1]=i;
        }
        
        Arrays.sort(arr, (x,y)->x[0]-y[0]);

        int[] pos=new int[n];
        for(int i=0;i<n;i++){
            pos[arr[i][1]]=i;
        }

        int[] comp=new int[n];
        int curComp=0;
        for(int i=1;i<n;i++){
            if(arr[i][0]-arr[i-1][0]>maxDiff) curComp++;
            comp[i]=curComp;
        }

        int[] l=new int[n];
        int[] r=new int[n];

        int left=0;
        for(int i=0;i<n;i++){
            while(arr[i][0]-arr[left][0]>maxDiff) left++;
            l[i]=left;
        }
        int right=0;
        for(int i=0;i<n;i++){
            while(right+1<n && arr[right+1][0]-arr[i][0]<=maxDiff) right++;
            r[i]=right;
        }


        int m=queries.length;
        int[] res=new int[m];
        // Binary Lifting Table (Precomputing 2^k jumps)
        int LOG = 32 - Integer.numberOfLeadingZeros(n);
        int[][] upLeft = new int[n][LOG];
        int[][] upRight = new int[n][LOG];

        for (int i = 0; i < n; i++) {
            upLeft[i][0] = l[i];
            upRight[i][0] = r[i];
        }

        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                upLeft[i][k] = upLeft[upLeft[i][k - 1]][k - 1];
                upRight[i][k] = upRight[upRight[i][k - 1]][k - 1];
            }
        }

        // O(log N) Queries
        for (int i = 0; i < m; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            if (u == v) {
                res[i] = 0;
                continue;
            }

            int uPos = pos[u];
            int vPos = pos[v];

            if (comp[uPos] != comp[vPos]) {
                res[i] = -1;
                continue;
            }

            int steps = 0;
            int curr = uPos;

            // Jump right
            if (uPos < vPos) {
                for (int k = LOG - 1; k >= 0; k--) {
                    if (upRight[curr][k] < vPos) {
                        curr = upRight[curr][k];
                        steps += (1 << k);
                    }
                }
            } 
            // Jump left
            else {
                for (int k = LOG - 1; k >= 0; k--) {
                    if (upLeft[curr][k] > vPos) {
                        curr = upLeft[curr][k];
                        steps += (1 << k);
                    }
                }
            }
            
            // Loop leaves us 1 step short of the target
            res[i] = steps + 1;
        }

        return res;
    }
}
class Solution {
    public int[] minCost(int[] nums, int[][] queries) {
        int q=queries.length;
        int n=nums.length;
        
        int[] costRight=new int[n];
        int[] costLeft=new int[n];
        for(int i=0;i<n;i++){
            if(i<n-1){
                int d=Math.abs(nums[i]-nums[i+1]);
                if(i==0 || d<Math.abs(nums[i]-nums[i-1])){
                    costRight[i]=1;
                }else{
                    costRight[i]=d; 
                }
            }
            if(i>0){
                int d=Math.abs(nums[i]-nums[i-1]);
                if(i==n-1 || d<=Math.abs(nums[i]-nums[i+1])){
                    costLeft[i]=1;
                }else{
                    costLeft[i]=d;
                }
            }
        }

        int[] preRight=new int[n];
        for(int i=1;i<n;i++) {
            preRight[i]=preRight[i-1]+costRight[i-1];
        }
        int[] preLeft=new int[n];
        for(int i=n-2;i>=0;i--) {
            preLeft[i]=preLeft[i+1]+costLeft[i+1];
        }

        int[] res=new int[q];
        for(int i=0;i<q;i++){
            int l=queries[i][0], r=queries[i][1];
            if(l<r){
                res[i]=preRight[r]-preRight[l];
            }else if(r<l){
                res[i]=preLeft[r]-preLeft[l];
            }
        }

        return res;
    }
}
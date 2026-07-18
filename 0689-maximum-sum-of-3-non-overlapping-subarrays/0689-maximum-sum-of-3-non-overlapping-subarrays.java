class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n=nums.length;
        
        int m=n-k+1;
        int[] window=new int[m];
        int cur=0;
        for(int i=0;i<n;i++){
            cur+=nums[i];
            if(i>=k) cur-=nums[i-k];
            if(i>=k-1) window[i-k+1]=cur;
        }

        int[] left=new int[m];
        int bestleft=0;
        for(int i=0;i<m;i++){
            if(window[i]>window[bestleft]){
                bestleft=i;
            }
            left[i]=bestleft;
        }

        int[] right=new int[m];
        int bestright=m-1;
        for(int i=m-1;i>=0;i--){
            if(window[i]>=window[bestright]){
                bestright=i;
            }
            right[i]=bestright;
        }

        int[] res=new int[3];
        int sum=-1;
        for(int i=k;i<m-k;i++){
            int l=left[i-k];
            int r=right[i+k];

            int total=window[i]+window[l]+window[r];

            if(total>sum){
                sum=total;
                res[0]=l;
                res[1]=i;
                res[2]=r;
            }
        }

        return res;
    }
}
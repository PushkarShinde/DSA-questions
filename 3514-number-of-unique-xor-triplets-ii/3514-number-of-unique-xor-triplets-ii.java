class Solution{
    public int uniqueXorTriplets(int[] nums){
        int n=nums.length;
        if(n==1) return 1;
        
        int m=0;
        for(int i:nums){
            m=Math.max(m, i);
        }

        int msb=32-Integer.numberOfLeadingZeros(m);
        int cap=1<<msb;

        boolean[] s1=new boolean[cap+1];

        boolean[] s2=new boolean[cap+1];

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                s1[(nums[i]^nums[j])]=true;
            }
        }

        for(int i=0;i<=cap;i++){
            if(s1[i]){
                for(int k:nums){
                    s2[i^k]=true;
                }
            }
        }

        int count=0;
        for(boolean v:s2){
            if(v) count++;
        }

        return count;
    }
}
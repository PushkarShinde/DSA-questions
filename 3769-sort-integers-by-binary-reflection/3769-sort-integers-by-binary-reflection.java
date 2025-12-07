class Solution {
    public int[] sortByReflection(int[] nums) {
        int n=nums.length;
        int[][] pair=new int[n][2];
        for(int i=0;i<n;i++){
            pair[i][0]=nums[i];
            pair[i][1]=reflection(nums[i]);
        }
        
        Arrays.sort(pair, (a,b)->{
            if(a[1]==b[1]) return Integer.compare(a[0],b[0]);
            return Integer.compare(a[1],b[1]);
        });

        int[] res=new int[n];
        for(int i=0;i<n;i++){
            res[i]=pair[i][0];
        }
        return res;
    }

    private int reflection(int num){
        int res=0;
        int temp=num;
        while(temp>0){
            res=(res << 1) | (temp & 1);
            temp>>=1;
        }
        return res;
    }
}
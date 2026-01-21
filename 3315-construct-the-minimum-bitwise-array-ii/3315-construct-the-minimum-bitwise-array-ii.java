class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n=nums.size();
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            int num=nums.get(i);
            int bin=Integer.bitCount(num);
            if(bin<2){
                res[i]=-1;
                continue;
            }
            int dig=1;
            while(true){
                if(((dig<<1)&num)==0){
                    num=num & ~dig;
                    break;
                }
                dig=dig<<1;
            }
            res[i]=num;
        }   
        return res;
    }
}
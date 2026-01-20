class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n=nums.size();
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            int num=nums.get(i);
            int bin=Integer.bitCount(num);
            if(bin<2) {
                res[i]=-1;
                continue;
            }
            for(int j=1;j<num;j++){
                int newNum=(j | (j+1));
                if(newNum==num){
                    res[i]=j;
                    break;
                }
            }
        }
        return res;
    }
}
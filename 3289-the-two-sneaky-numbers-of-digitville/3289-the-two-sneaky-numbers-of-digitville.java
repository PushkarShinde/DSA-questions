class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] res=new int[2];
        int[] fre=new int[101];
        int ind=0;
        for(int i:nums){
            if(fre[i]>0) res[ind++]=i;
            fre[i]++;
        }
        return res;
    }
}
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int[] pos=new int[n/2];
        int[] neg=new int[n/2];
        int[] res=new int[n];
        int j=0,k=0;
        for(int i=0;i<n;i++){
            if(nums[i]<0){
                neg[j]=nums[i];
                j++;
            }else{
                pos[k]=nums[i];
                k++;
            }
        }
        int h=0, l=0, m=0;
        while(h<n){
            if(h%2==0){
                res[h]=pos[l];
                l++;
            }else{
                res[h]=neg[m];
                m++;
            }
            h++;
        }
        return res;
    }
}
class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        if(n==1) return 1;
        int[] arr=new int[n];
        arr[0]=nums[0];
        int i=1,j=1;
        while(j<n){
            if(nums[j-1]!=nums[j]){
                arr[i++]=nums[j];
            }
            j++;
        }
        for(int k=0;k<i;k++){
            nums[k]=arr[k];
        }
        return i;
    }
}
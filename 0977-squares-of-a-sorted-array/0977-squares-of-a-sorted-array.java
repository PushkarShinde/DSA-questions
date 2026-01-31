class Solution {
  public int[] sortedSquares(int[] nums) {
    int n=nums.length;
    int[] sq=new int[n];
    int l=0, r=n-1;
    for(int i=n-1;i>=0;i--){
      if(Math.abs(nums[l])<Math.abs(nums[r])){
        sq[i]=nums[r]*nums[r];
        r--;
      }else{
        sq[i]=nums[l]*nums[l];
        l++;
      }
    }
    return sq;
  }
}
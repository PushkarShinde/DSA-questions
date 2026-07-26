class Solution {
    int a=Integer.MIN_VALUE, b=Integer.MIN_VALUE, c=Integer.MIN_VALUE;
    public int maximumProduct(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);

        return Math.max(nums[n-1]*nums[n-2]*nums[n-3],
                        nums[n-1]*nums[1]*nums[0]);
    }
}
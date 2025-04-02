class Solution {
    public int majorityElement(int[] nums) {
        /* MOST OPTIMAL
        Boyre-Moore Voting Algorithm */
        int ele=nums[0];
        int count=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(count==0) ele=nums[i];
            if(ele==nums[i]) count++;
            else count--;
        }
        return ele;
    }
}
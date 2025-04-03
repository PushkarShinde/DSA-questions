class Solution {
    public int longestConsecutive(int[] nums) {
        /*
        GOOD APPROACH  TC-O(NlogN)

        Arrays.sort(nums);
        int n=nums.length;
        if(n==1) return 1;
        if(n==0) return 0;
        int count=1;
        int consecutive=1;

        for(int i=0;i<n-1;i++){
            if(nums[i] == nums[i + 1]) continue;
            if(nums[i+1]==nums[i]+1){
                consecutive++;
            }else{
                count=Math.max(consecutive, count);
                consecutive=1;
            }
        }
        return Math.max(consecutive, count);
        */

        //OPTIMAL TC-O(N)
        if (nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num); // Store unique numbers in HashSet
        int maxLength = 0;
        for (int num : set) {
            // Start a new sequence only if `num - 1` is not present
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int streak = 1;
                // Count consecutive numbers
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    streak++;
                }
                maxLength = Math.max(maxLength, streak);
            }
        }
        return maxLength;
    }
}
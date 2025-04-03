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

        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) set.add(num); // Store unique elements in sorted order

        int maxLength = 1;
        int currentStreak = 1;
        Integer prev = null;

        for (int num : set) {
            if (prev != null && num == prev + 1) {
                currentStreak++; // Extend sequence
            } else {
                maxLength = Math.max(maxLength, currentStreak); // Update max length
                currentStreak = 1; // Reset for new sequence
            }
            prev = num; // Update previous element
        }

        return Math.max(maxLength, currentStreak); // Final check
    }
}
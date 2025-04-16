class Solution {
    public long countGood(int[] nums, int k) {
        long n=nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        long left = 0, result = 0, pairs = 0;
        for (int right = 0; right < n; right++) {
            int val = nums[right];
            int count = freq.getOrDefault(val, 0);
            pairs += count; // adding how many existing `val`s to pair with
            freq.put(val, count + 1);
            while (pairs >= k) {
                result += (n - right); // All subarrays starting from left to right are valid
                int leftVal = nums[(int) left];
                int leftCount = freq.get(leftVal);
                pairs -= (leftCount - 1); // remove pair contribution of this number
                freq.put(leftVal, leftCount - 1);
                left++;
            }
        }
        return result;
    }
}
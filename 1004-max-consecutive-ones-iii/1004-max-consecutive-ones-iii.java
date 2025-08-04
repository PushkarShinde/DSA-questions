class Solution {
    public int longestOnes(int[] nums, int k) {
        Map<Integer, Integer> map=new HashMap<>();
        int left=0;
        int maxOne=0;
        int n=nums.length;
        int zero=0;
        for(int right=0; right<n;right++){
            if(nums[right]==0) zero++;
            map.put(nums[right], map.getOrDefault(nums[right], 0)+1);
            while(zero>k){
                map.put(nums[left], map.get(nums[left])-1);
                if(nums[left]==0) zero--;
                left++;
            }
            maxOne=Math.max(maxOne, right-left+1);
        }
        return maxOne;
    }
}
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMostKOdd(nums, k)-atMostKOdd(nums, k-1);
    }

    private int atMostKOdd(int[] nums, int k){
        int left=0;
        int count=0;
        int oddCount=0;
        int n=nums.length;
        // Queue<Integer> que=new ArrayList<>();
        for(int right=0;right<n;right++){
            if(nums[right]%2==1) oddCount++;
            while(oddCount>k){
                if(nums[left]%2==1) oddCount--;
                left++;
            }
            count+=right-left+1;
        }
        return count;
    }
}
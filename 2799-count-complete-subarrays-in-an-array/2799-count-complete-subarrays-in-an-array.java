class Solution {
    public int countCompleteSubarrays(int[] nums) {
        // OPTIMAL O(NlogN)
        int n=nums.length;
        HashSet<Integer> unique=new HashSet<>();
        for(int num:nums) unique.add(num);
        int uc=unique.size();

        HashMap<Integer, Integer> freq=new HashMap<>();
        int count=0; int l=0;
        for(int r=0;r<n;r++){
            freq.put(nums[r],freq.getOrDefault(nums[r],0)+1);
            while(freq.size()==uc){
                count+=n-r;
                freq.put(nums[l],freq.get(nums[l])-1);
                if(freq.get(nums[l])==0) freq.remove(nums[l]);
                l++;
            }
        }
        return count;
    }
}
/**
This is the key insight:
    -Imagine left = 1 and right = 3 in a window [a, b, c], and it contains all unique elements.
    -Then not only [1...3] is valid, but also:
    [1...3], [1...4], [1...5], ..., [1...n-1]
    -So, for every left where the current window is valid, every subarray that ends at right, right+1, ..., n-1 will still include all the needed elements.
    -Hence, we count all of them at once with (n - right).
 */
// Yess khud se kiya :)
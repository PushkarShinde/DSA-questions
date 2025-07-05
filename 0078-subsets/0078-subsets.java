class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<(1<<n);i++){ //(1<<n) is equal to Math.pow(2,n); think about it
            List<Integer> subset=new ArrayList<>();
            for(int j=0;j<n;j++){
                if((i & (1<<j)) !=0){
                    subset.add(nums[j]);
                }
            }
            ans.add(subset);
        }
        return ans;
    }
}
/**
\U0001f4a1 Why This Works:
Each number from 0 to 2^n - 1 represents a subset:

Each bit in the number tells you whether to include (1) or exclude (0) an element at that index.

For example, with nums = [1, 2, 3]:

i = 5 (binary 101) → includes nums[0] and nums[2] → subset: [1, 3]
 */
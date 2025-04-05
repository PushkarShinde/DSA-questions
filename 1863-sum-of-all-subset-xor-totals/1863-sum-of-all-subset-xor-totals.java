class Solution {
    int total=0;
    private void dfs(int[] nums, int index, int curXor){
        if(index==nums.length){
            total+=curXor;
            return;
        }
        // include element
        dfs(nums, index+1, curXor^nums[index]);
        // exclude element
        dfs(nums, index+1, curXor);
    }
    public int subsetXORSum(int[] nums) {
        dfs(nums,0,0);
        return total;
    }
}

// wow
// Things to learn -> Recursion/Backtracking + Bitwise operations
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, nums, new ArrayList<>(), 0);
        return res;
    }
    private void backtrack(List<List<Integer>> res, int[] nums, List<Integer> temp, int ind){
        int n=nums.length;
        if(res.contains(temp)) return;//don't include copy
        res.add(new ArrayList<>(temp)); // 0 elements
        for(int i=ind;i<n;i++){
            temp.add(nums[i]);//include
            backtrack(res, nums, temp, i+1);
            temp.remove(temp.size()-1);//not include
        }
    }
}
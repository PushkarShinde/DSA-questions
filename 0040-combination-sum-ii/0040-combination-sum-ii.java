class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(candidates); // Sort to easily skip duplicates
        backtrack(candidates,target, 0, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(int[] candidates, int target, int ind, List<Integer> curr, List<List<Integer>> result){
        int n=candidates.length;
        if(target==0){ //base case
            result.add(new ArrayList(curr));
            return;
        }

        for (int i = ind; i < candidates.length; i++) {
        // \U0001f501 Skip duplicates
            if (i > ind && candidates[i] == candidates[i - 1]) continue;

            // If number is too large, break (since array is sorted)
            if(target<candidates[i]) break;

            curr.add(candidates[i]);
            backtrack(candidates,target-candidates[i], i+1, curr, result);
            curr.remove(curr.size()-1);

        }
    }
}
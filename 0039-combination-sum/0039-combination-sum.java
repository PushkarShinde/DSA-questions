class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        backtrack(candidates,target, 0, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(int[] candidates, int target, int ind, List<Integer> curr, List<List<Integer>> result){
        int n=candidates.length;
        if(target==0){ //base case
            result.add(new ArrayList(curr));
            return;
        }

        if(target<0 || ind>=n){ //invalid
            return;
        }

    // \U0001f501 Try including the current element (reuse allowed)
        curr.add(candidates[ind]);
        backtrack(candidates,target-candidates[ind], ind, curr, result);
        curr.remove(curr.size()-1);

    // \U0001f501 Try skipping the current element (move to next)
        backtrack(candidates,target, ind+1, curr, result);
    }
}
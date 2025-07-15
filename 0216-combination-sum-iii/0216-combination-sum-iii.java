class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new ArrayList<>();
        solve(1, res, new ArrayList<>(), k, n);
        return res;
    }
    private void solve(int dig, List<List<Integer>> res, List<Integer> curr, int k, int n){
        if(curr.size()==k){
            if(n==0){
                res.add(new ArrayList<>(curr));
            }
            return;
        }
        for(int i=dig;i<=9;i++){
            if(i>n) break;
            curr.add(i);
            solve(i+1, res, curr, k, n-i);
            curr.remove(curr.size()-1);

        }
    }
}

/**
\U0001f9e0 Key Idea: Backtracking
You're trying different combinations by:
-choosing a number,
-reducing the target sum (n) by that number,
-and repeating the process until you've picked k numbers or exceeded the target.
 */
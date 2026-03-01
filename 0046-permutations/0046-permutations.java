class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res=new ArrayList<>();
        solve(nums, 0, new ArrayList<>());
        return res;
    }
    private void solve(int[] a, int mask, List<Integer> cur){
        int n=a.length;
        if(cur.size()==n){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i=0;i<n;i++){
            if((mask&(1<<i))!=0) continue;
            cur.add(a[i]);
            solve(a,mask|(1<<i),cur);
            cur.remove(cur.size()-1);
        }
    }
}
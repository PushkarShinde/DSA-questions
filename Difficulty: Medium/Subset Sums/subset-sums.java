// User function Template for Java//User function Template for Java
class Solution {
    public ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> res=new ArrayList<>();
        solve(0, 0, arr, res);
        Collections.sort(res);
        return res;
    }
    private void solve(int ind, int sum, int[] arr, ArrayList<Integer> res){
        if(ind==arr.length) {
            res.add(sum);
            return;
        }
        
        solve(ind+1, sum+arr[ind], arr, res);
        solve(ind+1, sum, arr, res);
    }
}
class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> res=new HashSet<>();
        Set<Integer> pre=new HashSet<>();
        for(int i: arr){
            Set<Integer> cur = new HashSet<>();
            cur.add(i);
            for(int x: pre){
                cur.add(x|i);
            }
            pre=cur;
            res.addAll(cur);
        }
        return res.size();
    }
    /**
    At every index, you keep track of all possible OR values ending at that index using a set. Here's the plan:
    Let cur be the set of ORs that can be formed ending at arr[i].
    Let prev be the set from the previous iteration (index i - 1).
    cur will contain:
    arr[i]
    All (x | arr[i]) for x ∈ prev
    You add everything from cur into a global Set so duplicates are removed automatically.
     */
}
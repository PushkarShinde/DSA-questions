class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        List<Integer> res=new ArrayList<>();
        int q=queries.length;
        int n=nums.length;
        Map<Integer, TreeSet<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.computeIfAbsent(nums[i],k-> new TreeSet<>()).add(i);
        }
        for(int i=0;i<q;i++){
            int ind=queries[i];
            int target=nums[ind];
            TreeSet<Integer> val=map.get(target);
            if(val.size()==1){
                res.add(-1);
                continue;
            }

            int minDist=3*n;

            Integer left=val.lower(ind);
            Integer right=val.higher(ind);

            // int left=Math.abs(ind+n-val);//val is at right of the ind
            // left=Math.min(left, (n-ind)+val);//the val is at left of the ind
            // int right=Math.abs(val-ind);//simple diff is smaller
            if(left==null) left=val.last();
            if(right==null) right=val.first();

            int d1=Math.abs(left-ind);
            int d2=Math.abs(right-ind);       

            minDist=Math.min(minDist, n-d1);
            minDist=Math.min(minDist, d1);
            minDist=Math.min(minDist, n-d2);
            minDist=Math.min(minDist, d2);
            res.add(minDist);
        }
        return res;
    }
}
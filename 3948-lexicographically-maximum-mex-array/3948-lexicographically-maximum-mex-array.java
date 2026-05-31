class Solution {
    public int[] maximumMEX(int[] nums) {
        int n=nums.length;
        List<Integer> res=new ArrayList<>();

        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.computeIfAbsent(nums[i],x->new ArrayList<>()).add(i);
        }

        int i=0;
        while(i<n){
            Set<Integer> set=new HashSet<>();
            int mex=0;
            int j=i;
            while(j<n){
                set.add(nums[j]);
                while(set.contains(mex)) mex++;
                j++;
                
                List<Integer> mexPos=map.getOrDefault(mex, Collections.emptyList());
                int lo=0, hi=mexPos.size()-1;
                while(lo<=hi){
                    int mid=lo+(hi-lo)/2;
                    if(mexPos.get(mid)>=j){
                        hi=mid-1;
                    }else{
                        lo=mid+1;
                    }
                }
                boolean ageHai=lo<mexPos.size();
                if(!ageHai) break;
            }
            res.add(mex);
            i=j;
        }
        return res.stream().mapToInt(x->x).toArray();
    }
}
class Solution {
    public int findMin(int[] nums) {
        Set<Integer> set=new LinkedHashSet<>();
        for(int i:nums){
            set.add(i);
        }
        List<Integer> a=new ArrayList<>(set);
        int n=a.size();
        int l=0, r=n-1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(a.get(mid)<a.get(r)){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return a.get(l);
    }
}
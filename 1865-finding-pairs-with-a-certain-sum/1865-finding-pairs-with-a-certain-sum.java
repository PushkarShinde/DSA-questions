class FindSumPairs {
    int[] nums1;
    int[] nums2;
    Map<Integer, Integer> map2=new HashMap<>();
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1=nums1;
        this.nums2=nums2;
        for(int n: nums2){
            map2.put(n, map2.getOrDefault(n,0)+1);
        }
    }
    
    public void add(int index, int val) {
        map2.put(nums2[index], map2.getOrDefault(nums2[index],0)-1);
        if(map2.get(nums2[index])==0) map2.remove(nums2[index]);//VVIMP
        nums2[index]+=val;
        map2.put(nums2[index], map2.getOrDefault(nums2[index],0)+1);
    }
    
    public int count(int tot) {
        int cnt=0;
        for(int a: nums1){
            int b=tot-a;
            cnt+=map2.getOrDefault(b,0);
        }
        return cnt;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */
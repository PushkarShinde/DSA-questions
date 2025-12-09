class Solution {
    //[84,2,93,1,2,2,26]
    private int mod=(int)1e9+7;
    public int specialTriplets(int[] nums) {
        int n=nums.length;//n=7
        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.computeIfAbsent(nums[i],k-> new ArrayList<>()).add(i);
        }//2->[1,4,5], 1->[3]
        long count=0;

        for(int j=0;j<n;j++){
            int val=nums[j]; //1->[3]
            int target=val*2;
            if(!map.containsKey(target)) continue;
            List<Integer> indI=map.get(target);//2->[1,4,5]
            
            int left=before(indI, j); //left>=j
            int right=after(indI, j);
            count=(count+ (long)left*right)%mod;
        }
        return (int)count;
    }
    private int before(List<Integer> list, int x){
        int n=list.size();
        int left=0, right=n;
        while(left<right){
            int mid=left+(right-left)/2;
            if(x>list.get(mid)){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }
    private int after(List<Integer> list, int x){
        int n=list.size();
        int left=0, right=n-1;
        int result=0;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(x<list.get(mid)){
                result=n-mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return result;
    }
}
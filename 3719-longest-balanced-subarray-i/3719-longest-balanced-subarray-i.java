class Solution {
    public int longestBalanced(int[] nums) {
        Set<Integer> even=new HashSet<>();
        Set<Integer> odd=new HashSet<>();
        int n=nums.length;
        int res=0;
        for(int l=0;l<n;l++){
            for(int r=l;r<n;r++){
                int cur=nums[r];
                if(cur%2!=0){
                    odd.add(cur);
                }else{
                    even.add(cur);
                }
                if(odd.size()==even.size()){
                    res=Math.max(res, r-l+1);
                }
            }
            odd.clear();
            even.clear();
        }
        return res;
    }
}
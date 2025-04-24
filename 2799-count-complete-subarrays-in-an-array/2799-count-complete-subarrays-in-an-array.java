class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n=nums.length;
        HashSet<Integer> unique=new HashSet<>();
        for(int num:nums) unique.add(num);
        int uc=unique.size();

        int count=0;
        for(int i=0;i<n;i++){
            HashSet<Integer> subUnique=new HashSet<>();
            for(int j=i;j<n;j++){
                subUnique.add(nums[j]);
                if(subUnique.size()==uc) count++;
            }
        }
        return count;
    }
}
// Yess khud se kiya :)
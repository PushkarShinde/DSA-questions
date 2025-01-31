class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int n=nums.size(), k=1;
        if(n==0) return 0;
        for(int i=0;i<n;i++){
            if(nums[i]!=nums[k-1]){
                nums[k]=nums[i];
                k++;
            }
        }
        return k;
    }
};
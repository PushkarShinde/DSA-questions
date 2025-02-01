class Solution {
public:
    bool isArraySpecial(vector<int>& nums) {
        if(nums.size()==1) return true;
        int n=nums.size();

        for(int i=1;i<n;i++){
            int pre=nums[i-1];
            int post=nums[i];
            if((pre+post)%2==0){
                return false;
            }
        }
        return true;
    }
};
class Solution {
public:
    bool isArraySpecial(vector<int>& nums) {
        int n=nums.size();
        if(n==1) return true;
        int sum=nums[0];
        int key=0;
        for(int i=1;i<n;i++){
            sum+=nums[i];
            if(sum%2==0) {
                return false;
            }
        }
        return true;
    }
};
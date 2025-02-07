class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int num=0;
        for(int n:nums){
            if(n!=val) {
                nums[num++]=n;
            }
        }
        return num;
    }
};
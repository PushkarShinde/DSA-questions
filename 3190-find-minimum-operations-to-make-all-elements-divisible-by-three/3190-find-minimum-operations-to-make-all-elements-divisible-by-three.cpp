class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        int count=0;
        for(int num : nums){
            if(num%3==0){
                continue;
            } else if(num%3==1){
                num--;
                count++;
            } else if(num%3==2){
                num++;
                count++;
            }
        }
        return count;
    }
};
class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int n=digits.size();
        int key=0;
        for(int i=n-1;i>=0;i--){
            if(digits[i]!=9) {
                digits[i]++;
                break;
            } else {
                digits[i]=0;
                key++;
                continue;
            }
        }
        if(key==n) {
            digits.insert(digits.begin(),1);
        }
        return digits;
    }
};
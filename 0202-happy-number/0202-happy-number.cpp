class Solution {
public:
    bool isHappy(int n) {
        int count=0;
        int num=n;
        while(num!=1){
            vector<int>digits;
            while(num!=0){
                digits.insert(digits.begin(),num%10);
                num/=10;
            }
            for(auto i: digits){
                num+=(i*i);
            }
            count++;
            if(count>100){
                break;
            }
        }
        if(num==1){
            return true;
        } else{
            return false;
        }
    }
};
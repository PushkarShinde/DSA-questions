class Solution {
public:
    vector<int> digits(int x){
        vector<int> digs;
        while(x){
            digs.push_back(x%10);
            x/=10;
        }
        return digs;
    }
    bool isPalindrome(int x) {
        vector<int>digs=digits(x);
        int n=digs.size();
        bool key;
            for(int i=0;i<n/2;i++){
                if(digs[i]==digs.at(n-1-i)){
                    key=true;
                } else{
                    key=false;
                    break;
                }
            }
            if(x<0){
                key=false;
            }
            return key;
    }
};
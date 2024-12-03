class Solution {
public:
    void reverseString(vector<char>& s) {
        for(int i=s.size()-2; i>=0; i--){
            s.push_back(s[i]);
        }
        for(int i=0; i<s.size()-1; i++){
            s.erase(s.begin());
        }
        for(auto a: s){
            cout << a;
        }
    }
};
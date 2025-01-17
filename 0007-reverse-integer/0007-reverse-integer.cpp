class Solution {
public:
    string rev(string str) {
        std::reverse(str.begin(), str.end());
        return str;
    }

    long reverse(int x) {
        if(x>=0){
            return (long)(stoi(rev(to_string(x))));
        } else{
            return (long)((-1)*stoi(rev(to_string(x*(-1)))));
        }
    }
};
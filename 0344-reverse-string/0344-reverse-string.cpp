class Solution {
public:
    void reverseString(vector<char>& s) {
        char temp;
        int n=s.size();
        for(int i=0;i<n/2; i++){
            temp = s[i];
            s[i]=s[n-1-i];
            s[n-1-i]=temp;
        }
    }
};
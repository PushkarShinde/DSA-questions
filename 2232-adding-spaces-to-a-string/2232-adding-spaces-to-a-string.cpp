class Solution {
public:
    string addSpaces(string s, vector<int>& spaces) {
        string result;
        int sp=0;
        for (int i=0; i<s.length();i++){
            if(sp< spaces.size() && i==spaces[sp]){
                sp++;
            }
            result+=s[i];
        }
        return result;
    }
};
class Solution {
public:
    int scoreOfString(string s) {
        int score = 0;
        for(int i=0;i<s.length()-1;i++){
            int a = static_cast<int>(s.at(i));
            int b = static_cast<int>(s.at(i+1));
            int c = abs(a-b);
            score+=c;
        }
    return score;
    }
};
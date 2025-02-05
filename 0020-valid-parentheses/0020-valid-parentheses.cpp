class Solution {
public:
    bool isValid(string s) {
        stack<char> st;
        unordered_map<char, char> bracket_map = {{')', '('}, {']', '['}, {'}', '{'}};
        if(s.length()%2!=0) return false;
        for (char c : s) {
            // Check if it's a closing bracket
            if (bracket_map.count(c)) {
                char top = st.empty() ? '#' : st.top();
                if (top == bracket_map[c]) {
                    st.pop();
                } else {
                    return false;
                }
            } else {
                st.push(c); // Push opening brackets
            }
        }
        
        return st.empty();
    }
};

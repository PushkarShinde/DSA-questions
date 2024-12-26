class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        // Sort both greed factor (g) and cookie sizes (s)
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());

        int i = 0, j = 0; // i tracks children, j tracks cookies
        int count = 0;

        // Use a two-pointer approach
        while (i < g.size() && j < s.size()) {
            if (s[j] >= g[i]) { // Cookie satisfies the child's greed
                count++;
                i++; // Move to the next child
            }
            j++; // Move to the next cookie
        }

        return count;
    }
};
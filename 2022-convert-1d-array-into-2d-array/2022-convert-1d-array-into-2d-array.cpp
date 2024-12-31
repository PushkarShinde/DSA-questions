class Solution {
public:
    vector<vector<int>> construct2DArray(vector<int>& original, int m, int n) {
        vector<vector<int>>result(m, vector<int>(n));
        if (original.size() != m * n) {
            return {}; // Return an empty vector if conversion isn't possible
        }
        // int k=0;
        for(size_t i=0;i<m;i++){
            for(size_t j=0;j<n;j++){
                // result[i][j]=original[k++];
                result[i][j]=original[i*n+j];
            }
        }
        return result;
    }
};
class Solution {
public:
    bool isToeplitzMatrix(vector<vector<int>>& matrix) {
        int rows = matrix.size();
        int cols = matrix[0].size();

        // Check all diagonals starting from the first row
        for (int col = 0; col < cols; ++col) {
            if (!checkDiagonal(matrix, 0, col)) return false;
        }

        // Check all diagonals starting from the first column (excluding the top-left element)
        for (int row = 1; row < rows; ++row) {
            if (!checkDiagonal(matrix, row, 0)) return false;
        }

        return true;
    }

private:
    bool checkDiagonal(const vector<vector<int>>& matrix, int row, int col) {
        int value = matrix[row][col];
        int rows = matrix.size();
        int cols = matrix[0].size();

        while (row < rows && col < cols) {
            if (matrix[row][col] != value) return false;
            row++;
            col++;
        }
        return true;
    }
};
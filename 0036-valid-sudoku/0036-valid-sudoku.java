class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int r = 0; r < 9; r++) {
            Set<Character> set = new HashSet<>();
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;
                if (set.contains(board[r][c])) return false;
                set.add(board[r][c]);
            }
        }
        for (int c = 0; c < 9; c++) {
            Set<Character> set = new HashSet<>();
            for (int r = 0; r < 9; r++) {
                if (board[r][c] == '.') continue;
                if (set.contains(board[r][c])) return false;
                set.add(board[r][c]);
            }
        }
        
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Set<Character> set = new HashSet<>();
                for (int row = i; row < i + 3; row++) {
                    for (int col = j; col < j + 3; col++) {
                        if (board[row][col] == '.') continue;
                        if (set.contains(board[row][col])) return false;
                        set.add(board[row][col]);
                    }
                }
            }
        }

        return true;
    }
}
package Strings;

public class WordSearch79 {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtrack(board, word, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, String word, int index, int row, int col) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '#'; // Mark as visited

        boolean found = backtrack(board, word, index + 1, row - 1, col) ||
                        backtrack(board, word, index + 1, row + 1, col) ||
                        backtrack(board, word, index + 1, row, col - 1) ||
                        backtrack(board, word, index + 1, row, col + 1);

        board[row][col] = temp; // Restore original character
        return found;
    }
}

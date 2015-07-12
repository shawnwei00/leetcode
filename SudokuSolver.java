/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * Empty cells are indicated by the character '.'.
 * 
 * You may assume that there will be only one unique solution.
 *
 */

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        solveSudoku(board, 0);
    }
    
    public boolean solveSudoku(char[][] board, int num) {
        if (num == 81) return true;
        
        int row = num / 9;
        int col = num % 9;
        
        if (board[row][col] != '.') return solveSudoku(board, num + 1);
        
        for (char guess = '1'; guess <= '9'; guess++) {
            if (isValid(board, row, col, guess)) {
                board[row][col] = guess;
                if (!solveSudoku(board, num + 1)) {
                    board[row][col] = '.';
                } else {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isValid(char[][] board, int row, int col, int guess) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == guess) return false;
        }
                
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == guess) return false;
        }
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[row/3*3+i][col/3*3+j] == guess) return false;
            }
        }
        return true;
    }
}
import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * 
 * -------------------------------------
 * | 5 | 3 |   |   | 7 |   |   |   |   |
 * -------------------------------------
 * | 6 |   |   | 1 | 9 | 5 |   |   |   |
 * -------------------------------------
 * |   | 9 | 8 |   |   |   |   | 6 |   |
 * -------------------------------------
 * | 8 |   |   |   | 6 |   |   |   | 3 |
 * -------------------------------------
 * | 4 |   |   | 8 |   | 3 |   |   | 1 |
 * -------------------------------------
 * | 7 |   |   |   | 2 |   |   |   | 6 |
 * -------------------------------------
 * |   | 6 |   |   |   |   | 2 | 8 |   |
 * -------------------------------------
 * |   |   |   | 4 | 1 | 9 |   |   | 5 |
 * -------------------------------------
 * |   |   |   |   | 8 |   |   | 7 | 9 |
 * -------------------------------------
 * 
 * A partially filled sudoku which is valid.
 * 
 * Note:
 * 
 * A valid Sudoku board (partially filled) is not necessarily solvable. 
 * Only the filled cells need to be validated.
 *
 */

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) return false;
        
        if (!rowValidate(board)) return false;
        if (!colValidate(board)) return false;
        if (!gridValidate(board)) return false;
        
        return true;
    }
    
    public boolean rowValidate(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<Character>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                if (board[i][j] < '1' || board[i][j] > '9') return false;
                if (set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }
        return true;
    }
    
    
    public boolean colValidate(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<Character>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') continue;
                if (board[j][i] < '1' || board[j][i] > '9') return false;
                if (set.contains(board[j][i])) return false;
                set.add(board[j][i]);
            }
        }
        return true;
    }
    
    public boolean gridValidate(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Set<Character> set = new HashSet<Character>();
                for (int n = 0; n < 3; n++) {
                    for (int m = 0; m < 3; m++) {
                        if (board[3*i+n][3*j+m] == '.') continue;
                        if (board[3*i+n][3*j+m] < '1' || board[3*i+n][3*j+m] > '9') return false;
                        if (set.contains(board[3*i+n][3*j+m])) return false;
                        set.add(board[3*i+n][3*j+m]);
                    }
                }
            }
        }
        return true;
    }
    
}
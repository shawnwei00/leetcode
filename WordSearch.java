/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, 
 * where "adjacent" cells are those horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once.
 * 
 * For example,
 * 
 * Given board =
 * [
 * 	["ABCE"],
 * 	["SFCS"],
 * 	["ADEE"]
 * ]
 * 
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 *
 */

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) return false;
        
        int row = board.length;
        int col = board[0].length;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (exist(board, word, i, j, 0)) return true;
            }
        }
        
        return false;
    }
    
    public boolean exist(char[][] board, String word, int i, int j, int index) {
        char c = word.charAt(index);
        
        if (c != board[i][j]) return false;
        if (index == word.length()-1) return true;
        
        int row = board.length;
        int col = board[0].length;
        
        board[i][j] = 0;
        
        if (i > 0 && exist(board, word, i-1, j, index+1)) return true;
        if (i < row-1 && exist(board, word, i+1, j, index+1)) return true;
        if (j > 0 && exist(board, word, i, j-1, index+1)) return true;
        if (j < col-1 && exist(board, word, i, j+1, index+1)) return true;
        
        board[i][j] = c;
        return false;
    }
}
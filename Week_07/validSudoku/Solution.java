package validSudoku;

/**
 * https://leetcode-cn.com/problems/valid-sudoku
 *
 * @author David Liu
 */
public class Solution {

    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][] boxes = new int[9][9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int n = board[i][j] - '1';
                    int boxIndex = (i / 3) * 3 + j / 3;
                    if (rows[i][n] == 1) return false;
                    else rows[i][n] = 1;
                    if (cols[j][n] == 1) return false;
                    else cols[j][n] = 1;
                    if (boxes[boxIndex][n] == 1) return false;
                    else boxes[boxIndex][n] = 1;
                }
            }
        }

        return true;
    }
}

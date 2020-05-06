package minesweeper;

/**
 * https://leetcode-cn.com/problems/minesweeper/
 *
 * @author David Liu
 */
public class Solution {

    private final int[][] moveDirections = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 0}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };

    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0], col = click[1];

        if (board[row][col] == 'M') {
            board[row][col] = 'X';
            return board;
        }

        return clickBoard(board, row, col);
    }

    private char[][] clickBoard(char[][] board, int row, int col) {
        int num = getMineCount(board, row, col);
        if (num == 0) board[row][col] = 'B';
        else {
            board[row][col] = Character.forDigit(num, 10);
            return board;
        }

        for (int[] moveDirection : moveDirections) {
            int offsetRow = row + moveDirection[0], offsetCol = col + moveDirection[1];
            if (offsetRow >= 0 && offsetRow < board.length && offsetCol >= 0 && offsetCol < board[0].length && board[offsetRow][offsetCol] == 'E')
                board = clickBoard(board, offsetRow, offsetCol);
        }

        return board;
    }

    private int getMineCount(char[][] board, int row, int col) {
        int num = 0;
        for (int[] moveDirection : moveDirections) {
            int offsetRow = row + moveDirection[0], offsetCol = col + moveDirection[1];
            if (offsetRow >= 0 && offsetRow < board.length && offsetCol >= 0 && offsetCol < board[0].length && board[offsetRow][offsetCol] == 'M') num++;
        }
        return num;
    }
}

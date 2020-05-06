package minesweeper;

import org.junit.Assert;
import org.junit.Test;

/**
 * minesweeper test case
 *
 * @author David Liu
 */
public class TestCase {

    private final Solution solution = new Solution();

    @Test
    public void case1() {
        char[][] board = {{'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};
        int[] click = {3, 0};
        char[][] expect = {{'B', '1', 'E', '1', 'B'},
                {'B', '1', 'M', '1', 'B'},
                {'B', '1', '1', '1', 'B'},
                {'B', 'B', 'B', 'B', 'B'}};
        char[][] actual = solution.updateBoard(board, click);
        Assert.assertArrayEquals(expect, actual);
    }

    @Test
    public void case2() {
        char[][] board = {{'B', '1', 'E', '1', 'B'},
                {'B', '1', 'M', '1', 'B'},
                {'B', '1', '1', '1', 'B'},
                {'B', 'B', 'B', 'B', 'B'}};
        int[] click = {1, 2};
        char[][] expect = {{'B', '1', 'E', '1', 'B'},
                {'B', '1', 'X', '1', 'B'},
                {'B', '1', '1', '1', 'B'},
                {'B', 'B', 'B', 'B', 'B'}};
        char[][] actual = solution.updateBoard(board, click);
        Assert.assertArrayEquals(expect, actual);
    }

}

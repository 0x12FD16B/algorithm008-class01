package numOfIslands;

import org.junit.Assert;
import org.junit.Test;

/**
 * nums of islands test case
 *
 * @author David Liu
 */
public class TestCase {

    private final Solution solution = new Solution();

    @Test
    public void case1() {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int expect = 1;
        int actual = solution.numIslands(grid);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void case2() {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int expect = 3;
        int actual = solution.numIslands(grid);
        Assert.assertEquals(expect, actual);
    }

}

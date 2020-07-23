package minimumPathSum;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author David Liu
 */
public class TestCase {

    private final Solution solution = new Solution();

    @Test
    public void case1() {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int expect = 7;
        Assert.assertEquals(solution.minPathSum_dp2(grid), expect);
    }

    @Test
    public void case2() {
        int[][] grid = {
                {1, 2, 5},
                {3, 2, 1}
        };
        int expect = 6;
        Assert.assertEquals(solution.minPathSum_dp2(grid), expect);
    }
}

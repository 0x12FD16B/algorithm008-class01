package nQueens;

import org.junit.Test;

/**
 * n queens test case
 *
 * @author David Liu
 */
public class TestCase {

    private final Solution solution = new Solution();

    @Test
    public void case1() {
        System.out.println(solution.solveNQueens(4));
    }
}

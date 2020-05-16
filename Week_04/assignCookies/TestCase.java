package assignCookies;

import org.junit.Assert;
import org.junit.Test;

/**
 * assign cookies test case
 *
 * @author David Liu
 */
public class TestCase {

    private final Solution solution = new Solution();

    @Test
    public void case1() {
        int[] g = {1, 2, 3}, s = {1, 2};
        int expect = 2;
        int actual = solution.findContentChildren(g, s);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void case2() {
        int[] g = {1, 2, 3}, s = {2};
        int expect = 1;
        int actual = solution.findContentChildren(g, s);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void case3() {
        int[] g = {2, 2, 3}, s = {1};
        int expect = 0;
        int actual = solution.findContentChildren(g, s);
        Assert.assertEquals(expect, actual);
    }

}

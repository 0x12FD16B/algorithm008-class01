package sqrtx;

import org.junit.Assert;
import org.junit.Test;

/**
 * sqrtx test case
 *
 * @author David Liu
 */
public class TestCase {

    private final Solution solution = new Solution();

    @Test
    public void case1() {
        int x = 8;
        int expect = 2;
        int actual = solution.mySqrt(x);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void case2() {
        int x = 4;
        int expect = 2;
        int actual = solution.mySqrt(x);
        Assert.assertEquals(expect, actual);
    }

}

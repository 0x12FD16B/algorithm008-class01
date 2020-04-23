package addDigits;

import org.junit.Assert;
import org.junit.Test;

/**
 * add digits test case
 *
 * @author David Liu
 */
public class TestCase {

    private final Solution solution = new Solution();

    @Test
    public void case1() {
        int num = 38;
        int expect = 2;
        int actual = solution.addDigits(num);
        Assert.assertEquals(expect, actual);
    }
}

package numberOfBits;

import org.junit.Assert;
import org.junit.Test;

/**
 * number of 1 bits test case
 *
 * @author David Liu
 */
public class TestCase {

    private final Solution solution = new Solution();

    @Test
    public void case1() {
        int n = Integer.valueOf("00000000000000000000000000001011", 2);
        int expect = 3;
        int actual = solution.hammingWeight(n);
        Assert.assertEquals(expect, actual);
    }

}

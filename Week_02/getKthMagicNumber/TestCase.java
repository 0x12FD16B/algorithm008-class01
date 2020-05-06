package getKthMagicNumber;

import getKthMagicNumber_week3.Solution;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author David Liu
 */
public class TestCase {

    private final getKthMagicNumber_week3.Solution solution = new Solution();

    @Test
    public void case1() {
        int k = 1;
        int expect = 1;
        int actual = solution.getKthMagicNumber(k);
        Assert.assertEquals(actual, expect);
    }
}

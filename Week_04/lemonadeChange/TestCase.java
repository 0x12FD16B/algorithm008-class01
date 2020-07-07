package lemonadeChange;

import org.junit.Assert;
import org.junit.Test;

/**
 * lemonadeChange test case
 *
 * @author David Liu
 */
public class TestCase {

    private final Solution solution = new Solution();

    @Test
    public void case1() {
        int[] bills = {5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5};
        boolean actual = solution.lemonadeChange(bills);
        Assert.assertTrue(actual);
    }
}

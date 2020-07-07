package maximumLengthOfRepeatedSubarray;

import org.junit.Assert;
import org.junit.Test;

/**
 * maximum-length-of-repeated-subarray test case
 *
 * @author David Liu
 */
public class TestCase {

    private final Solution solution = new Solution();

    @Test
    public void case1() {
        int[] A = {1, 2, 3, 2, 1}, B = {3, 2, 1, 4, 7};
        Assert.assertEquals(solution.findLength2(A, B), 3);
    }

}

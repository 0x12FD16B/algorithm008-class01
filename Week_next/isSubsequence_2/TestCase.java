package isSubsequence_2;

import org.junit.Assert;
import org.junit.Test;

/**
 * is subsequence test case
 *
 * @author David Liu
 */
public class TestCase {

    private final Solution solution = new Solution();

    @Test
    public void case1() {
        String s = "abc", t = "ahbgdc";
        Assert.assertTrue(solution.isSubSequence(s, t));
    }
}

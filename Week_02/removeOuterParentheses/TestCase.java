package removeOuterParentheses;

import org.junit.Assert;
import org.junit.Test;

/**
 * remove-outermost-parentheses test case
 *
 * @author David Liu
 */
public class TestCase {

    private final Solution solution = new Solution();

    @Test
    public void case1() {
        String s = "(()())(())";
        String expect = "()()()";
        String actual = solution.removeOuterParentheses(s);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void case2() {
        String s = "(()())(())(()(()))";
        String expect = "()()()()(())";
        String actual = solution.removeOuterParentheses(s);
        Assert.assertEquals(expect, actual);
    }
}

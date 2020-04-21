package bullsAndCows;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Bulls and cows Test Case
 *
 * @author David Liu
 */
public class TestCase {

    private final Solution solution = new Solution();

    @Test
    public void case1() {
        final String expectResult = "2A2B";
        String hint = solution.getHint("1807", "0817");
        assertEquals("secret 1807 and guess 0817 should return hint 2A2B", expectResult, hint);
    }
}

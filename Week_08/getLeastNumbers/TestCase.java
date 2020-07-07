package getLeastNumbers;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author David Liu
 */
public class TestCase {

    private final Solution solution = new Solution();

    @Test
    public void case1() {
        int[] arr = {3, 2, 1};
        int k = 2;
        System.out.println(Arrays.toString(solution.getLeastNumbers(arr, 2)));
    }
}

package permutations;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * permutations test case
 *
 * @author David Liu
 */
public class TestCase {

    private final Solution solution = new Solution();

    @Test
    public void case1() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> expect = new ArrayList<>();
        expect.add(Arrays.asList(1, 2, 3));
        expect.add(Arrays.asList(1, 3, 2));
        expect.add(Arrays.asList(2, 1, 3));
        expect.add(Arrays.asList(2, 3, 1));
        expect.add(Arrays.asList(3, 2, 1));
        expect.add(Arrays.asList(3, 1, 2));
        List<List<Integer>> permute = solution.permute(nums);
    }
}

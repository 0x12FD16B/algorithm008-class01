package minimumAbsoluteDifference;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * minimum-absolute-difference test case
 *
 * @author David Liu
 */
public class TestCase {

    private final Solution solution = new Solution();

    @Test
    public void case1() {
        int[] arr = new int[]{4, 2, 1, 3};
        List<List<Integer>> expect = new LinkedList<>();
        expect.add(Arrays.asList(1, 2));
        expect.add(Arrays.asList(2, 3));
        expect.add(Arrays.asList(3, 4));
        List<List<Integer>> actual = solution.minimumAbsDifference(arr);
        Assert.assertEquals(actual, expect);
    }

    @Test
    public void case2() {
        int[] arr = new int[]{1, 3, 6, 10, 15};
        List<List<Integer>> expect = new LinkedList<>();
        expect.add(Arrays.asList(1, 3));
        List<List<Integer>> actual = solution.minimumAbsDifference(arr);
        Assert.assertEquals(actual, expect);
    }
}

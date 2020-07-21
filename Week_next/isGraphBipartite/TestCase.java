package isGraphBipartite;

import org.junit.Assert;
import org.junit.Test;

/**
 * is-graph-bipartite test case
 *
 * @author David Liu
 */
public class TestCase {

    private final Solution solution = new Solution();

    @Test
    public void case1() {
        int[][] graph = {
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2}
        };
        Assert.assertTrue(solution.isBipartite_dfs(graph));
    }

    @Test
    public void case2() {
        int[][] graph = {
                {1, 2, 3},
                {0, 2},
                {0, 1, 3},
                {0, 2}
        };
        Assert.assertFalse(solution.isBipartite_dfs(graph));
    }
}

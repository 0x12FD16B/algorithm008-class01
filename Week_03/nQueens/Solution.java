package nQueens;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/n-queens/
 *
 * @author David Liu
 */
public class Solution {

    private Set<Integer> cols;
    private Set<Integer> pie;
    private Set<Integer> na;

    public List<List<String>> solveNQueens(int n) {
        if (n < 1) return Collections.emptyList();
        cols = new HashSet<>();
        pie = new HashSet<>();
        na = new HashSet<>();
        List<List<String>> ans = new LinkedList<>();
        dfs(ans, new LinkedList<>(), n, 0);
        return ans;
    }

    private void dfs(List<List<String>> res, List<String> rowState, int n, int row) {
        // recursion terminator
        if (row == n) {
            res.add(new LinkedList<>(rowState));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || pie.contains(row + col) || na.contains(row - col)) continue;
            // process current level
            char[] lineState = new char[n];
            Arrays.fill(lineState, '.');
            lineState[col] = 'Q';
            String rowString = new String(lineState);
            rowState.add(rowString);
            cols.add(col);
            pie.add(row + col);
            na.add(row - col);
            // drill down
            dfs(res, rowState, n, row + 1);
            // reverse state
            rowState.remove(rowState.size() - 1);
            cols.remove(col);
            pie.remove(row + col);
            na.remove(row - col);
        }

    }
}

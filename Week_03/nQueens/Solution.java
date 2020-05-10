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
    private List<List<Integer>> result;

    public List<List<String>> solveNQueens(int n) {
        if (n < 1) return Collections.emptyList();
        cols = new HashSet<>();
        pie = new HashSet<>();
        na = new HashSet<>();
        result = new LinkedList<>();
        List<Integer> rowState = new LinkedList<>();
        dfs(n, 0, rowState);
        return generateResult(n);
    }

    private void dfs(int n, int row, List<Integer> rowState) {
        // recursion terminator
        if (row >= n) {
            result.add(rowState);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || pie.contains(row + col) || na.contains(row - col)) continue;
            // process current level
            cols.add(col);
            pie.add(row + col);
            na.add(row - col);
            // drill down
            rowState.add(col);
            // reverse state
            dfs(n, row + 1, rowState);
            rowState.remove(Integer.valueOf(col));
            cols.remove(col);
            pie.remove(row + col);
            na.remove(row - col);
        }

    }

    private List<List<String>> generateResult(int n) {
        List<List<String>> ans = new LinkedList<>();
        for (List<Integer> rowState : result) {
            List<String> t = new LinkedList<>();
            for (Integer col : rowState) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    if (i == col) builder.append("Q");
                    else builder.append(".");
                }
                t.add(builder.toString());
            }
            ans.add(t);
        }
        return ans;
    }
}

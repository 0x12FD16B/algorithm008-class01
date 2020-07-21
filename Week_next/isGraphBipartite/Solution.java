package isGraphBipartite;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/is-graph-bipartite
 *
 * @author David Liu
 */
public class Solution {

    private static final int UNCOLORED = 0;

    private static final int RED = 1;

    private static final int GREEN = 2;

    private static int[] color;

    private boolean valid = true;

    public boolean isBipartite_dfs(int[][] graph) {
        int n = graph.length;
        color = new int[n];
        Arrays.fill(color, UNCOLORED);
        for (int i = 0; i < n && valid; i++) {
            if (color[i] == UNCOLORED) dfs(graph, i, RED);
        }

        return valid;
    }

    private void dfs(int[][] graph, int node, int c) {
        color[node] = c;
        int nc = c == RED ? GREEN : RED;
        for (int n : graph[node]) {
            if (color[n] == UNCOLORED) {
                dfs(graph, n, nc);
                if (!valid) return;
            } else if (color[n] != nc) {
                valid = false;
                return;
            }
        }
    }

    public boolean isBipartite_bfs(int[][] graph) {
        int n = graph.length;
        color = new int[n];
        Arrays.fill(color, UNCOLORED);
        for (int i = 0; i < n; i++) {
            if (color[i] == UNCOLORED) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                color[i] = RED;
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    int nc = color[node] == RED ? GREEN : RED;
                    for (int neighbor : graph[node]) {
                        if (color[neighbor] == UNCOLORED) {
                            queue.offer(neighbor);
                            color[neighbor] = nc;
                        } else if (color[neighbor] != nc) {
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }
}

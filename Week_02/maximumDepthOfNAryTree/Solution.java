package maximumDepthOfNAryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 *
 * @author David Liu
 */
public class Solution {
    // BFS 遍历, 返回遍历深度
    public int maxDepth1(Node root) {
        if (root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                Node node = queue.poll();
                if (node.children != null && node.children.size() > 0)
                    for (Node child : node.children) queue.offer(child);
            }
            depth++;
        }
        return depth;
    }

    // 使用递归
    public int maxDepth2(Node root) {
        if (root == null) return 0;
        if (root.children.isEmpty()) return 1;
        int maxDepth = -1;
        for (Node child : root.children) maxDepth = Math.max(maxDepth, maxDepth2(child));
        return maxDepth + 1;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}

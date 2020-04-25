package minimumDepthOfBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 *
 * @author David Liu
 */
public class Solution {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int minLeft = minDepth(root.left);
        int minRight = minDepth(root.right);
        return root.left == null || root.right == null ? minLeft + minRight + 1 : Math.min(minLeft, minRight) + 1;
    }

    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            for (int i = 0; i < cnt; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) return level;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            level++;
        }
        return level;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}

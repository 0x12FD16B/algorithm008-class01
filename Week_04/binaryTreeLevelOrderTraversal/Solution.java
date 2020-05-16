package binaryTreeLevelOrderTraversal;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
 * @author David Liu
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> levelState = new ArrayList<>();
            Queue<TreeNode> temp = new LinkedList<>();
            for (TreeNode node : queue) {
                levelState.add(node.val);
                if (node.left != null) temp.offer(node.left);
                if (node.right != null) temp.offer(node.right);
            }
            ans.add(levelState);
            queue = temp;
        }
        return ans;
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

package diameterOfBinaryTree;

/**
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 *
 * @author David Liu
 */
public class Solution {

    private int max = 0;

    // 深度优先遍历, 使用类变量记录遍历最大的边数
    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return max;
    }

    // 优化问题解: 实际上就是求左子树和右子树最大深度的和
    public int diameterOfBinaryTree2(TreeNode root) {
        if (root == null) return 0;
        int cur = maxDepth(root.left) + maxDepth(root.right);
        int left = diameterOfBinaryTree2(root.left);
        int right = diameterOfBinaryTree2(root.right);
        return Math.max(cur, Math.max(left, right));

    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    private int traverse(TreeNode root) {
        if (root == null) return 0;
        int left = traverse(root.left);
        int right = traverse(root.right);
        max = Math.max(left + right, max);
        return Math.max(left, right) + 1;
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

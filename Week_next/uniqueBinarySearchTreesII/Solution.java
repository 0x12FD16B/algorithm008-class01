package uniqueBinarySearchTreesII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii
 *
 * @author David Liu
 */
public class Solution {
    // 时间复杂度: O(n *
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return Collections.emptyList();
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        // recursion terminator
        if (start > end) {
            res.add(null);
        } else if (start == end) {
            res.add(new TreeNode(start));
        } else {
            // 枚举所有的根节点, 构造二叉搜索树
            for (int i = start; i <= end; i++) {
                List<TreeNode> leftTrees = generateTrees(start, i - 1);
                List<TreeNode> rightTrees = generateTrees(i + 1, end);

                for (TreeNode leftTree : leftTrees) {
                    for (TreeNode rightTree : rightTrees) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftTree;
                        root.right = rightTree;
                        res.add(root);
                    }
                }
            }
        }

        return res;
    }

    static final class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}

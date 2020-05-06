package congWeiDaoTouDaYinLianBiaoLcof;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 *
 * @author David Liu
 */
public class Solution {

    private final List<Integer> res = new LinkedList<>();

    public int[] reversePrint1(ListNode head) {
        if (head == null) return new int[0];
        Stack<Integer> stack = new Stack<>();
        for (ListNode node = head; node != null; node = node.next) stack.push(node.val);
        int[] ans = new int[stack.size()];
        int p = 0;
        while (!stack.isEmpty()) ans[p++] = stack.pop();
        return ans;
    }

    public int[] reversePrint2(ListNode head) {
        if (head == null) return new int[0];
        recur(head);
        int[] ans = new int[res.size()];
        int p = 0;
        for (Integer re : res) ans[p++] = re;
        return ans;
    }

    private void recur(ListNode node) {
        if (node == null) return;
        recur(node.next);
        res.add(node.val);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

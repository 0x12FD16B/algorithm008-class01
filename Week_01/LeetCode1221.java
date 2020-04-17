/**
 * split-a-string-in-balanced-strings
 *
 * @author David Liu
 * @link https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
 */
public class LeetCode1221 {
    // 解法1: 使用两个变量来记录字符 R 和 L 出现的次数, 当 R 和 L 的出现的次数相等时, 结果 +1, 直到遍历结束
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public int balancedStringSplit1(String s) {
        int rc = 0, lc = 0, res = 0;
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (ch == 'R') rc++;
            else lc++;
            if (rc == lc) {
                rc = lc = 0;
                res++;
            }
        }
        return res;
    }

    // 解法2: 在解法 1 的基础上优化一下数量抵消思路, 使用一个变量来记录出现 'R' 和 'L' 抵消的状况, 每个结果子串中, 'R' 和 'L'
    // 数量一样达到平衡态, 使用 balance 记录平衡态, 当子串平衡时, balance = 0;
    // 从左向右遍历字符串中的每个字符, 当出现 'R' 时, balance = balance + 1; 当出现 'L' 时, balance = balance - 1;
    // 当遍历过程中, 出现了 balance = 0, 则结果数量增加 1
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public int balancedStringSplit2(String s) {
        int balance = 0, num = 0, res = 0;
        int length = s.length();

        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 'R') num++;
            else num--;
            if (num == 0) res++;
        }

        return res;
    }

}

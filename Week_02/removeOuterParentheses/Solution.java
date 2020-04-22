package removeOuterParentheses;

/**
 * https://leetcode-cn.com/problems/remove-outermost-parentheses/
 *
 * @author David Liu
 */
public class Solution {
    // 解法一: 一次遍历, 找到原语的切割字符的位置, 然后将移除括号后的子串放入到结果缓冲中
    // 时间复杂度: O(N)
    // 空间复杂度: O(N)
    // N 为字符串 S 的长度
    public String removeOuterParentheses(String S) {
        int start = 0;
        int p = 0;
        char[] chars = S.toCharArray();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') p++;
            if (chars[i] == ')') p--;
            if (p == 0) {
                res.append(S.substring(start + 1, i));
                start = i + 1;
            }
        }

        return res.toString();
    }

    // 解法二: 使用变量标记当前字符是否处于括号内, 将在外层括号内的字符添加到结果缓冲
    // 时间复杂度: O(N)
    // 空间复杂度: O(N)
    // N 为字符串 S 的长度
    public String removeOuterParentheses2(String S) {
        int level = 0;
        StringBuilder res = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (c == ')') level--;
            if (level >= 1) res.append(c);
            if (c == '(') level++;
        }

        return res.toString();
    }

}

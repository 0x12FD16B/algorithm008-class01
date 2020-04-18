import java.util.Stack;

/**
 * reverse-only-letters
 *
 * @author David Liu
 * @link https://leetcode-cn.com/problems/reverse-only-letters/
 */
public class LeetCode917 {
    // 解法1: 双指针法, 因为仅仅是将字母反序,
    // 所以可以分别让左下标指针扫描字母外的字符, 右下标指针扫描字母, 并将结果记录到结果中
    // 时间复杂度: O(S.length())
    // 空间复杂度: O(S.length())
    public String reverseOnlyLetters1(String S) {
        if (S == null || S.length() <= 1) return S;
        StringBuilder res = new StringBuilder();
        int length = S.length();
        int l = 0, r = length - 1;
        while (l < length) {
            char cl = S.charAt(l);
            if (Character.isLetter(cl)) {
                while (!Character.isLetter(S.charAt(r)))
                    r--;
                res.append(r--);
            } else {
                res.append(cl);
            }
            l++;
        }
        return res.toString();
    }

    // 解法2: 使用栈来处理字母逆序
    // 时间复杂度: O(S.length())
    // 空间复杂度: O(S.length())
    public String reverseOnlyLetters2(String S) {
        if (S == null || S.length() <= 1) return S;
        char[] chars = S.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (Character.isLetter(c)) {
                stack.push(c);
            }
        }

        StringBuilder res = new StringBuilder();
        for (char c : chars) {
            if (!Character.isLetter(c)) {
                res.append(c);
            } else {
                res.append(stack.pop());
            }
        }
        return res.toString();
    }
}

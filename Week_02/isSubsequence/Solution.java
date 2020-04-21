package isSubsequence;

/**
 * https://leetcode-cn.com/problems/is-subsequence/
 *
 * @author David Liu
 */
public class Solution {
    // 使用 java string api
    public boolean isSubsequence1(String s, String t) {
        int p = -1;
        for (char c : s.toCharArray()) {
            p = t.indexOf(c, p + 1);
            if (p < 0) return false;
        }

        return true;
    }

    public boolean isSubsequence2(String s, String t) {
        int sl = s.length(), tl = t.length();
        int p = 0, q = 0;
        while (p < sl && q < tl) {
            if (s.charAt(p) == t.charAt(q)) {
                p++;
            }
            q++;
        }

        return p == sl;
    }
}

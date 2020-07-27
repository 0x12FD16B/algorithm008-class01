package isSubsequence_2;

/**
 * https://leetcode-cn.com/problems/is-subsequence/
 *
 * @author David Liu
 */
public class Solution {

    public boolean isSubSequence(String s, String t) {
        int m = s.length(), n = t.length(), i = 0, j = 0;

        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) i++;
            j++;
        }

        return i == m;
    }
}

package assignCookies;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/assign-cookies
 *
 * @author David Liu
 */
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0, gl = g.length, sl = s.length, ans = 0;
        while (i < gl && j < sl) {
            if (g[i] <= s[j]) {
                ans++;
                i++;
                j++;
            } else if (g[i] > s[j]) j++;
        }
        return ans;
    }
}

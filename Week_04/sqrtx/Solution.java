package sqrtx;

/**
 * https://leetcode-cn.com/problems/sqrtx/
 *
 * @author David Liu
 */
public class Solution {

    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if ((double) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else r = mid - 1;
        }

        return ans;
    }

}

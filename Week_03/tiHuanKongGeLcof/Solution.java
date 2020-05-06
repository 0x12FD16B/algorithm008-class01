package tiHuanKongGeLcof;

/**
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 *
 * @author David Liu
 */
public class Solution {

    // 使用 String api
    public String replaceSpace1(String s) {
        if (s == null || s.length() == 0) return s;
        return s.replace(" ", "%20");
    }

    public String replaceSpace2(String s) {
        if (s == null || s.length() == 0) return s;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 0x20) ans.append("%20");
            else ans.append(s.charAt(i));
        }
        return ans.toString();
    }

}

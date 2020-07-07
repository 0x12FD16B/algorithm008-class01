package longestCommonPrefix;

/**
 * @author David Liu
 */
public class Solution {

    public static void main(String[] args) {
        String[] strs = {""};
        System.out.println(new Solution().longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        int pos = 0;
        boolean breakFlag = false;
        do {
            char ch = strs[0].charAt(pos);
            for (String str : strs) {
                if (ch != str.charAt(pos)) {
                    breakFlag = true;
                    break;
                }
            }
            pos++;
        } while (!breakFlag);

        return strs[0].substring(0, pos - 1);
    }
}

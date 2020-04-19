import java.util.LinkedHashMap;
import java.util.Map;

/**
 * di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 *
 * @author David Liu
 * @link https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 */
public class LeetCodeInterview50 {
    // 解法1: 使用 LinkedHash Map, 将每个字符出现的次数都使用 Hash 表记录下来
    // 时间复杂度: O(N)
    // 空间复杂度: O(N)
    // N = s.length();
    public char firstUniqChar1(String s) {
        if (s == null || s.length() == 0) return ' ';
        Map<Character, Integer> chCount = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            Integer c = chCount.getOrDefault(ch, 0);
            chCount.put(ch, c + 1);
        }

        for (Map.Entry<Character, Integer> entry : chCount.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return ' ';
    }

    // 解法2: 使用数组索引每个字符出现的次数, 空间换时间
    // 时间复杂度: O(N)
    // 空间复杂度: O(1)
    // N = s.length()
    public char firstUniqChar2(String s) {
        if (s == null || s.length() == 0) return ' ';
        char[] charMap = new char[26];
        for (int i = 0; i < s.length(); i++) {
            charMap[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (charMap[ch - 'a'] == 1) {
                return ch;
            }
        }

        return ' ';
    }
}

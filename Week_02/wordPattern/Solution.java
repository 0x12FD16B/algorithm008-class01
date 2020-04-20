package wordPattern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/word-pattern
 *
 * @author David Liu
 */
public class Solution {

    // 解法一: 使用 Map + Set
    // Map 记录 pattern 中字符到 str 中单词的映射, Set 记录已经记入 Map 中的单词值
    // 时间复杂度: O(N)
    // 空间复杂度: O(N)
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        String[] words = str.split(" ");
        if (pattern.length() != words.length) return false;

        for (int i = 0; i < pattern.length(); i++) {
            char k = pattern.charAt(i);
            if (map.containsKey(k)) {
                if (!map.get(k).equals(words[i])) {
                    return false;
                }
            } else {
                if (set.contains(words[i])) {
                    return false;
                }
                map.put(k, words[i]);
                set.add(words[i]);
            }
        }

        return true;
    }
}

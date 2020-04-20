package bullsAndCows;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/bulls-and-cows
 *
 * @author davidliu
 */
class Solution {
    // 解法一: 两次字符串遍历 + 哈希表
    // 时间复杂度: O(N)
    // 空间复杂度: O(N)
    public String getHint(String secret, String guess) {
        int bullsCnt = 0, cowsCnt = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        int length = secret.length();

        for (int i = 0; i < length; i++) {
            if (secret.charAt(i) == guess.charAt(i)) bullsCnt++;
            Integer secretCharCount = charMap.getOrDefault(secret.charAt(i), 0);
            charMap.put(secret.charAt(i), ++secretCharCount);
        }

        for (int i = 0; i < length; i++) {
            Integer guessCharCnt = charMap.getOrDefault(guess.charAt(i), 0);
            if (guessCharCnt > 0) {
                cowsCnt++;
                charMap.put(guess.charAt(i), --guessCharCnt);
            }
        }

        if (bullsCnt > 0) cowsCnt = cowsCnt - bullsCnt;
        return bullsCnt + "A" + cowsCnt + "B";
    }

    // 解法二: 一次遍历 + 哈希表
    // 时间复杂度: O(N)
    // 空间复杂度: O(N)
    public String getHint2(String secret, String guess) {
        int length = secret.length();
        int[] numDict = new int[10];
        int bullsCnt = 0, cowsCnt = 0;
        for (int i = 0; i < length; i++) {
            if (secret.charAt(i) == guess.charAt(i)) bullsCnt++;
            else {
                if (numDict[secret.charAt(i) - '0']++ < 0) ++cowsCnt;
                if (numDict[guess.charAt(i) - '0']-- > 0) ++cowsCnt;
            }
        }

        return bullsCnt + "A" + cowsCnt + "B";
    }
}
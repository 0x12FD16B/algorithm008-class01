package fizzBuzz;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/fizz-buzz
 *
 * @author David Liu
 */
public class Solution {

    // 解法一: 暴力法
    // 时间复杂度: O(N)
    // 空间复杂度: O(N)
    public List<String> fizzBuzz(int n) {
        if (n <= 0) {
            return Collections.emptyList();
        }

        List<String> res = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (i % 3 == 0 && i % 5 == 0) res.add("FizzBuzz");
            else if (i % 3 == 0) res.add("Fizz");
            else if (i % 5 == 0) res.add("Buzz");
            else res.add(String.valueOf(i));
        }

        return res;
    }

    // 解法二: 使用哈希表优化分支判断逻辑
    // 时间复杂度: O(N)
    // 空间复杂度: O(N)
    public List<String> fizzBuzz2(int n) {
        if (n <= 0) {
            return Collections.emptyList();
        }

        Map<Integer, String> stringMap = new LinkedHashMap<>();
        stringMap.put(3, "Fizz");
        stringMap.put(5, "Buzz");

        List<String> res = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            StringBuilder builder = new StringBuilder();
            for (Integer k : stringMap.keySet()) {
                if (i % k == 0) builder.append(k);
            }
            if (builder.length() == 0) builder.append(i);
            res.add(builder.toString());
        }
        return res;
    }
}

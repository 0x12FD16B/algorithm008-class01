package addDigits;

/**
 * https://leetcode-cn.com/problems/add-digits
 *
 * @author David Liu
 */
public class Solution {

    public int addDigits(int num) {
        while (num / 10 > 0) {
            int n = 0;
            do {
                n += num % 10;
                num = num / 10;
            } while (num > 0);
            num = n;
        }

        return num;
    }

}

package numberOfBits;

/**
 * https://leetcode-cn.com/problems/number-of-1-bits/
 *
 * @author David Liu
 */
public class Solution {
    // you need to treat n as an unsigned value
    // recursion
    public int hammingWeight(int n) {
        return n == 0 ? 0 : (n & 1) + hammingWeight(n >>> 1);
    }

    // use Integer Api
    public int hammingWeight1(int n) {
        return n == 0 ? 0 : Integer.bitCount(n);
    }

    // iterate each bit to count 1 bits
    public int hammingWeight2(int n) {
        if (n == 0) return 0;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += (n & 1);
            n = (n >>> 1);
        }
        return count;
    }

    // use expression n & (n - 1) to count 1 bits
    public int hammingWeight3(int n) {
        if (n == 0) return 0;
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

}

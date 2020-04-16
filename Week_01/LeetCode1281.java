/**
 * LeetCode 1281
 *
 * @author David Liu
 * @link https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 */
public class LeetCode1281 {
    public static void main(String[] args) {
        LeetCode1281 leetCode1281 = new LeetCode1281();
        int case1 = 1;
        // expect output: 0
        System.out.println(leetCode1281.subtractProductAndSum(case1));
        int case2 = 234;
        // expect output: 15
        System.out.println(leetCode1281.subtractProductAndSum(case2));
        int case3 = 4421;
        // expect output: 21
        System.out.println(leetCode1281.subtractProductAndSum(case3));
    }

    // 解法1: 截取出 n 的每位数字, 分别利用两个变量记录各位数字之和与各位数字之乘积
    // 时间复杂度: O(length(n))
    // 空间复杂度: O(1)
    public int subtractProductAndSum(int n) {
        if (n / 10 == 0) return 0;

        int sum = 0, prd = 1;

        while (n > 0) {
            int c = n % 10;
            sum += c;
            prd *= c;
            n = n / 10;
        }

        return prd - sum;
    }
}

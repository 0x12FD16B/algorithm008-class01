import java.util.Arrays;

class LeetCode66 {
    public static void main(String[] args) {
        LeetCode66 leetCode66 = new LeetCode66();
        int[] case1 = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(leetCode66.plusOne(case1)));
        int[] case2 = new int[]{1, 2, 9};
        System.out.println(Arrays.toString(leetCode66.plusOne(case2)));
        int[] case3 = new int[]{1, 9, 9};
        System.out.println(Arrays.toString(leetCode66.plusOne(case3)));
        int[] case4 = new int[]{9, 9, 9};
        System.out.println(Arrays.toString(leetCode66.plusOne(case4)));
    }

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return digits;
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] > 0) return digits;
        }

        int[] res = new int[length + 1];
        res[0] = 1;
        return res;
    }
}
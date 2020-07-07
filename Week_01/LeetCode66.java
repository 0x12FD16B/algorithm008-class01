class LeetCode66 {
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
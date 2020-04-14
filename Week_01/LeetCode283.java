class LeetCode283 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int length = nums.length;
        int lastNonZeroIndex = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroIndex++] = nums[i];
            }
        }

        for (int i = lastNonZeroIndex; i < length; i++) {
            nums[i] = 0;
        }
    }
}
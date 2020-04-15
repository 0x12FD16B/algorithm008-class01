public class LeetCode189 {
    // 解法1: 依次往后挪动 k 次数组, 让 nums.length - 1 的元素挪到第 0 个元素来
    // 时间复杂度 O(k * n)
    // 空间复杂度 O(1)
    public void rotate_solution1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return;
        int length = nums.length;
        k = k % length;
        for (int i = 0; i < k; i++) {
            int t = nums[length - 1];
            System.arraycopy(nums, 0, nums, 1, length - 1);
            nums[0] = t;
        }
    }

    // 解法2: 循环找位法, 让数组中第 i 个元素到第 (i + k) % nums.length 的位置去, 循环条件比较难找
    // 通过标记移动了多少个元素来标记退出循环(如果 nums.length 个元素都移动了元素, 则说明数组旋转完成)
    // 时间复杂度 O(n)
    // 空间复杂度 O(1)
    public void rotate_solution2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return;
        int length = nums.length, count = 0;
        k = k % length;
        for (int start = 0; count < length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % length;
                int t = nums[next];
                nums[next] = prev;
                prev = t;
                current = next;
                count++;
            } while (start != current);
        }
    }

    // 解法3: 开辟一个新的数组, 将数组中第 i 个元素到第 (i + k) % nums.length 的位置去
    // 时间复杂度 O(n)
    // 空间复杂度 O(n)
    public void rotate_solution3(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return;
        int length = nums.length;
        k = k % length;
        int[] s = new int[length];
        for (int i = 0; i < length; i++) {
            s[(i + k) % length] = nums[i];
        }

        System.arraycopy(s, 0, nums, 0, length);
    }
}

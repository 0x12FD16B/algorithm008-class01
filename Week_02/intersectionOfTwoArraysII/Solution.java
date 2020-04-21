package intersectionOfTwoArraysII;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 *
 * @author David Liu
 */
public class Solution {

    // 解法一: 暴力法
    // 枚举 nums1 中的所有元素, 判断其在 nums2 中是否存在, 将 nums2 中在交集中的元素存放在一个 set 中, 避免重复输出
    // 时间复杂度: O(N^2)
    // 空间复杂度: O(N)
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];
        int nl2 = nums2.length;
        Set<Integer> nums2IntersectIdx = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for (int value : nums1) {
            for (int j = 0; j < nl2; j++) {
                if (value == nums2[j] && !nums2IntersectIdx.contains(j)) {
                    res.add(value);
                    nums2IntersectIdx.add(j);
                    break;
                }
            }
        }

        int[] r = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            r[i] = res.get(i);
        }

        return r;
    }

    // 解法二: 排序过后, 使用双指针法
    // 时间复杂度: O(NlogN)
    // 空间复杂度: O(N)
    public int[] intersect2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];
        int nl1 = nums1.length, nl2 = nums2.length;
        if (nl1 > nl2) {
            return intersect2(nums2, nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> t = new ArrayList<>();
        for (int p1 = 0, p2 = 0; p1 < nums1.length && p2 < nums2.length; ) {
            if (nums1[p1] < nums2[p2]) {
                p1++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                t.add(nums1[p1]);
                p1++;
                p2++;
            }
        }

        int[] res = new int[t.size()];
        for (int i = 0; i < t.size(); i++) {
            res[i] = t.get(i);
        }

        return res;
    }

    // 解法二优化版本, 优化空间使用, 使用一个标记下标 k, 使最终的交集结果在 nums1[0:k]
    // 时间复杂度: O(NlogN)
    // 空间复杂度: O(1)
    public int[] intersect3(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];
        int nl1 = nums1.length, nl2 = nums2.length;
        if (nl1 > nl2) {
            return intersect3(nums2, nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int k = 0;
        for (int p1 = 0, p2 = 0; p1 < nums1.length && p2 < nums2.length; ) {
            if (nums1[p1] < nums2[p2]) {
                p1++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                nums1[k++] = nums1[p1];
                p1++;
                p2++;
            }
        }

        return Arrays.copyOfRange(nums1, 0, k);
    }

    // 解法三: 使用 hashmap 遍历一个数组, 记录其中每个数字出现的次数
    // 再遍历第二个数组, 如果第二个数组中的元素在 hashmap 中存在, 并且 value 为正数, 那么将该数字放到结果中
    // 时间复杂度: O(N)
    // 空间复杂度: O(N)
    public int[] intersect4(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];
        int nl1 = nums1.length, nl2 = nums2.length;
        if (nl1 > nl2) {
            return intersect4(nums2, nums1);
        }

        Map<Integer, Integer> numCount = new HashMap<>();
        for (int n1 : nums1) {
            Integer count = numCount.getOrDefault(n1, 0);
            numCount.put(n1, ++count);
        }

        int k = 0;
        for (int n2 : nums2) {
            int count = numCount.getOrDefault(n2, 0);
            if (count > 0) {
                nums1[k++] = n2;
                numCount.put(n2, --count);
            }
        }

        return Arrays.copyOfRange(nums1, 0, k);
    }
}

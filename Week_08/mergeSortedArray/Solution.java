package mergeSortedArray;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 *
 * @author David Liu
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int size = m + n, p = size - 1;
        int i = nums1.length - 1, j = nums2.length - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) nums1[p--] = nums1[i--];
            else nums1[p--] = nums2[j--];
        }

        while (i >= 0) nums1[p--] = nums1[i--];
        while (j >= 0) nums1[p--] = nums2[j--];
    }

    public static void main(String[] args) {
        
    }
}

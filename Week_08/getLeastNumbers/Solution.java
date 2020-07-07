package getLeastNumbers;

import java.util.Arrays;

/**
 * @author David Liu
 */
public class Solution {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) return new int[0];
        return search(arr, 0, arr.length - 1, k - 1);
    }

    private int[] search(int[] arr, int lo, int hi, int k) {
        int p = partition(arr, lo, hi);
        if (p == k) {
            return Arrays.copyOf(arr, p + 1);
        }

        return p > k ? search(arr, lo, p - 1, k) : search(arr, p + 1, hi, k);
    }

    private int partition(int[] a, int begin, int end) {
// pivot: 标杆位置，counter: 小于pivot的元素的个数
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (a[i] < a[pivot]) {
                int temp = a[counter];
                a[counter] = a[i];
                a[i] = temp;
                counter++;
            }
        }
        int temp = a[pivot];
        a[pivot] = a[counter];
        a[counter] = temp;
        return counter;
    }
}

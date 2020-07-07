package relativeSortArray;

/**
 * https://leetcode-cn.com/problems/relative-sort-array/
 *
 * @author David Liu
 */
public class Solution {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr2 == null || arr2.length == 0) return arr1;
        int[] bucket = new int[1001];
        for (int n : arr1)
            bucket[n]++;

        int p = 0;
        for (int n : arr2) {
            while (bucket[n] > 0) {
                arr1[p++] = n;
                bucket[n]--;
            }
        }

        for (int i = 0; i < 1001; i++) {
            while (bucket[i] > 0) {
                arr1[p++] = i;
                bucket[i]--;
            }
        }

        return arr1;
    }
}

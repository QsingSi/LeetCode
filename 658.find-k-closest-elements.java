import java.util.Collections;

/*
 * [658] Find K Closest Elements
 *
 * https://leetcode.com/problems/find-k-closest-elements/description/
 *
 * algorithms
 * Medium (34.75%)
 * Total Accepted:    19.7K
 * Total Submissions: 56.7K
 * Testcase Example:  '[1,2,3,4,5]\n4\n3'
 *
 *
 * Given a sorted array, two integers k and x, find the k closest elements to x
 * in the array.  The result should also be sorted in ascending order.
 * If there is a tie,  the smaller elements are always preferred.
 *
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5], k=4, x=3
 * Output: [1,2,3,4]
 *
 *
 *
 *
 * Example 2:
 *
 * Input: [1,2,3,4,5], k=4, x=-1
 * Output: [1,2,3,4]
 *
 *
 *
 * Note:
 *
 * The value k is positive and will always be smaller than the length of the
 * sorted array.
 * ⁠Length of the given array is positive and will not exceed 104
 * ⁠Absolute value of elements in the array and x will not exceed 104
 *
 *
 *
 *
 *
 *
 * UPDATE (2017/9/19):
 * The arr parameter had been changed to an array of integers (instead of a
 * list of integers). Please reload the code definition to get the latest
 * changes.
 *
 */
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int index = 0;
        for (; index < arr.length; index++) {
            if (arr[index] > x)
                break;
        }
        if (index == 0)
            for (int i = 0; i < k; i++)
                res.add(arr[i]);
        else if (index == arr.length)
            for (int i = 0; i < k; i++)
                res.add(arr[arr.length - 1 - i]);
        else {
            int i = index - 1, j = index;
            while (k > 0) {
                if (i == -1) {
                    res.add(arr[j++]);
                } else if (j == arr.length) {
                    res.add(arr[i--]);
                } else if (Math.abs(arr[i] - x) <= Math.abs(arr[j] - x)) {
                    res.add(arr[i]);
                    i--;
                } else {
                    res.add(arr[j]);
                    j++;
                }
                k--;
            }
        }
        Collections.sort(res);
        return res;
    }
}

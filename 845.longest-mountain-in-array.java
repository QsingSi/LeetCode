/*
 * [875] Longest Mountain in Array
 *
 * https://leetcode.com/problems/longest-mountain-in-array/description/
 *
 * algorithms
 * Medium (30.39%)
 * Total Accepted:    4.6K
 * Total Submissions: 15.2K
 * Testcase Example:  '[2,1,4,7,3,2,5]'
 *
 * Let's call any (contiguous) subarray B (of A) a mountain if the following
 * properties hold:
 *
 *
 * B.length >= 3
 * There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] <
 * B[i] > B[i+1] > ... > B[B.length - 1]
 *
 *
 * (Note that B could be any subarray of A, including the entire array A.)
 *
 * Given an array A of integers, return the length of the longest mountain. 
 *
 * Return 0 if there is no mountain.
 *
 * Example 1:
 *
 *
 * Input: [2,1,4,7,3,2,5]
 * Output: 5
 * Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
 *
 *
 * Example 2:
 *
 *
 * Input: [2,2,2]
 * Output: 0
 * Explanation: There is no mountain.
 *
 *
 * Note:
 *
 *
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 *
 *
 * Follow up:
 *
 *
 * Can you solve it using only one pass?
 * Can you solve it in O(1) space?
 *
 *
 */
class Solution {
    public int longestMountain(int[] A) {
        if (A.length <= 2)
            return 0;
        int[] left = new int[A.length], right = new int[A.length];
        for (int i = 1; i < A.length; i++)
            left[i] = A[i] > A[i - 1] ? left[i - 1] : i;
        right[A.length - 1] = A.length - 1;
        for (int i = A.length - 2; i >= 0; i--)
            right[i] = A[i] > A[i + 1] ? right[i + 1] : i;
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (right[i] - left[i] >= 2 && right[i] - left[i] + 1 > max && right[i] != i && left[i] != i)
                max = right[i] - left[i] + 1;
        }
        return max;
    }
}

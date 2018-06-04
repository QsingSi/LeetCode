/*
 * [611] Valid Triangle Number
 *
 * https://leetcode.com/problems/valid-triangle-number/description/
 *
 * algorithms
 * Medium (41.98%)
 * Total Accepted:    18.9K
 * Total Submissions: 45.1K
 * Testcase Example:  '[2,2,3,4]'
 *
 * Given an array consists of non-negative integers,  your task is to count the
 * number of triplets chosen from the array that can make triangles if we take
 * them as side lengths of a triangle.
 *
 * Example 1:
 *
 * Input: [2,2,3,4]
 * Output: 3
 * Explanation:
 * Valid combinations are:
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 *
 *
 *
 * Note:
 *
 * The length of the given array won't exceed 1000.
 * The integers in the given array are in the range of [0, 1000].
 *
 *
 *
 */
class Solution {
    public int triangleNumber(int[] nums) {
        int cnt = 0;
        Arrays.sort(nums);
        int i = 0, j = nums.length - 2, k = nums.length - 1;
        for (; k > 1; k--) {
            i = 0;
            j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    cnt += j - i;
                    j--;
                } else
                    i++;
            }
        }
        return cnt;
    }
}

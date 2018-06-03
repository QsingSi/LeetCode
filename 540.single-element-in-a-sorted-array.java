/*
 * [540] Single Element in a Sorted Array
 *
 * https://leetcode.com/problems/single-element-in-a-sorted-array/description/
 *
 * algorithms
 * Medium (55.87%)
 * Total Accepted:    32.1K
 * Total Submissions: 57.4K
 * Testcase Example:  '[1,1,2]'
 *
 *
 * Given a sorted array consisting of only integers where every element appears
 * twice except for one element which appears once. Find this single element
 * that appears only once.
 *
 *
 * Example 1:
 *
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 *
 *
 *
 * Example 2:
 *
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 *
 *
 *
 * Note:
 * Your solution should run in O(log n) time and O(1) space.
 *
 *
 */
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int res = 0;
        for (int num : nums)
            res ^= num;
        return res;
    }
}

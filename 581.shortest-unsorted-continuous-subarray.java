/*
 * [581] Shortest Unsorted Continuous Subarray
 *
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
 *
 * algorithms
 * Easy (29.37%)
 * Total Accepted:    40.4K
 * Total Submissions: 137.7K
 * Testcase Example:  '[2,6,4,8,10,9,15]'
 *
 * Given an integer array, you need to find one continuous subarray that if you
 * only sort this subarray in ascending order, then the whole array will be
 * sorted in ascending order, too.
 *
 * You need to find the shortest such subarray and output its length.
 *
 * Example 1:
 *
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make
 * the whole array sorted in ascending order.
 *
 *
 *
 * Note:
 *
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means .
 *
 *
 */
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        Integer[] dummy = new Integer[nums.length];
        Integer[] help = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dummy[i] = i;
            help[i] = nums[i];
        }
        Arrays.sort(dummy, (a, b)->help[a] - help[b]);
        int start = 0, end = nums.length - 1;
        for (; start < nums.length; start++)
            if (start != dummy[start])
                break;
        for (; end >= 0; end--)
            if (end != dummy[end])
                break;
        return start < end ? end - start + 1 : 0;
    }
}

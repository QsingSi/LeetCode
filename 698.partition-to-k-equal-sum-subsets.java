/*
 * [698] Partition to K Equal Sum Subsets
 *
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
 *
 * algorithms
 * Medium (37.80%)
 * Total Accepted:    15.9K
 * Total Submissions: 41.9K
 * Testcase Example:  '[4,3,2,3,5,2,1]\n4'
 *
 * Given an array of integers nums and a positive integer k, find whether it's
 * possible to divide this array into k non-empty subsets whose sums are all
 * equal.
 *
 * Example 1:
 *
 * Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * Output: True
 * Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3),
 * (2,3) with equal sums.
 *
 *
 *
 * Note:
 * 1 .
 * 0 < nums[i] < 10000.
 *
 */
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0, max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        if (sum % k != 0 || max > sum / k)
            return false;
        return helper(nums, new boolean[nums.length], 0, k, 0, 0, sum / k);
    }
    private boolean helper(int[] nums, boolean[] visited, int start, int k, int cur_sum, int cur_num, int target) {
        if (k == 1)
            return true;
        if (cur_sum == target && cur_num > 0)
            return helper(nums, visited, 0, k - 1, 0, 0, target);
        for (int i = start; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (helper(nums, visited, i + 1, k, cur_sum + nums[i], cur_num + 1, target))
                    return true;
                visited[i] = false;
            }
        }
        return false;
    }
}

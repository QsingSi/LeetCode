/*
 * [377] Combination Sum IV
 *
 * https://leetcode.com/problems/combination-sum-iv/description/
 *
 * algorithms
 * Medium (42.83%)
 * Total Accepted:    60.2K
 * Total Submissions: 140.5K
 * Testcase Example:  '[1,2,3]\n4'
 *
 * ⁠Given an integer array with all positive numbers and no duplicates, find
 * the number of possible combinations that add up to a positive integer
 * target.
 *
 * Example:
 *
 * nums = [1, 2, 3]
 * target = 4
 *
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 *
 * Note that different sequences are counted as different combinations.
 *
 * Therefore the output is 7.
 *
 *
 *
 * Follow up:
 * What if negative numbers are allowed in the given array?
 * How does it change the problem?
 * What limitation we need to add to the question to allow negative numbers?
 *
 * Credits:Special thanks to @pbrother for adding this problem and creating all
 * test cases.
 */
class Solution {
    public int dfs(int[] nums, int target, int[] dp) {
        if (target < 0)
            return 0;
        if (dp[target] != -1)
            return dp[target];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += dfs(nums, target - nums[i], dp);
        }
        dp[target] = res;
        return res;
    }
    public int combinationSum4(int[] nums, int target) {
        if (nums.length == 0)
            return 0;
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0]  = 1;
        return dfs(nums, target, dp);
    }
}

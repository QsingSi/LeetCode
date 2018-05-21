/*
 * [368] Largest Divisible Subset
 *
 * https://leetcode.com/problems/largest-divisible-subset/description/
 *
 * algorithms
 * Medium (33.93%)
 * Total Accepted:    34.6K
 * Total Submissions: 102K
 * Testcase Example:  '[1,2,3]'
 *
 *
 * Given a set of distinct positive integers, find the largest subset such that
 * every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj
 * % Si = 0.
 *
 *
 * If there are multiple solutions, return any subset is fine.
 *
 *
 * Example 1:
 *
 * nums: [1,2,3]
 *
 * Result: [1,2] (of course, [1,3] will also be ok)
 *
 *
 *
 * Example 2:
 *
 * nums: [1,2,4,8]
 *
 * Result: [1,2,4,8]
 *
 *
 *
 * Credits:Special thanks to @Stomach_ache for adding this problem and creating
 * all test cases.
 */
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList();
        if (nums.length == 0)
            return res;
        int[] no = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int[] pre = new int[nums.length];
        int[] dp = new int[nums.length];
        Arrays.fill(pre, -1);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] % nums[i] == 0 || nums[i] % nums[j] == 0 ) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        pre[i]  = j;
                    }
                }
            }
            if (dp[i] > dp[max])
                max = i;
        }
        List<Integer> tmp = new ArrayList();
        while (max != -1) {
            tmp.add(no[max]);
            max = pre[max];
        }
        while (!tmp.isEmpty()) {
            res.add(tmp.remove(tmp.size() - 1));
        }
        return res;
    }
}

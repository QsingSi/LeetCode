import java.util.Map;

/*
 * [1] Two Sum
 *
 * https://leetcode.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (38.42%)
 * Total Accepted:    976K
 * Total Submissions: 2.5M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 *
 * Example:
 *
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 *
 *
 *
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mask = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (mask.containsKey(target - nums[i]))
                return new int[] {mask.get(target - nums[i]), i};
            else mask.put(nums[i], i);
        }
        return new int[0];
    }
}

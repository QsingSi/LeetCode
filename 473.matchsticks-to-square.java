import java.util.Map;

/*
 * [473] Matchsticks to Square
 *
 * https://leetcode.com/problems/matchsticks-to-square/description/
 *
 * algorithms
 * Medium (35.34%)
 * Total Accepted:    16.4K
 * Total Submissions: 46.4K
 * Testcase Example:  '[1,1,2,2,2]'
 *
 * Remember the story of Little Match Girl? By now, you know exactly what
 * matchsticks the little match girl has, please find out a way you can make
 * one square by using up all those matchsticks. You should not break any
 * stick, but you can link them up, and each matchstick must be used exactly
 * one time.
 *
 * ⁠Your input will be several matchsticks the girl has, represented with their
 * stick length. Your output will either be true or false, to represent whether
 * you could make one square using all the matchsticks the little match girl
 * has.
 *
 * Example 1:
 *
 * Input: [1,1,2,2,2]
 * Output: true
 *
 * Explanation: You can form a square with length 2, one side of the square
 * came two sticks with length 1.
 *
 *
 *
 * Example 2:
 *
 * Input: [3,3,3,3,4]
 * Output: false
 *
 * Explanation: You cannot find a way to form a square with all the
 * matchsticks.
 *
 *
 *
 * Note:
 *
 * The length sum of the given matchsticks is in the range of 0 to 10^9.
 * The length of the given matchstick array will not exceed 15.
 *
 *
 */
class Solution {
    private boolean dfs(int[] nums, boolean[] visit, int sum, int start, int target, int count) {
        if (count == 4) {
            for (boolean v : visit)
                if (!v)
                    return false;
            return true;
        } else if (sum > target)
            return false;
        else if (sum == target)
            return dfs(nums, visit, 0, 0, target, count + 1);
        else {
            for (int i = start; i < nums.length; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    if (dfs(nums, visit, sum + nums[i], i + 1, target, count))
                        return true;
                    visit[i] = false;
                }
            }
        }
        return false;
    }
    public boolean makesquare(int[] nums) {
        if (nums.length <= 3)
            return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int edge = sum / 4;
        if (sum != edge * 4)
            return false;
        return dfs(nums, new boolean[nums.length], 0, 0, edge, 0);
    }
}

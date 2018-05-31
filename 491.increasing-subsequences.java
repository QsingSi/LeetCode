import java.util.List;
import java.util.Set;

/*
 * [491] Increasing Subsequences
 *
 * https://leetcode.com/problems/increasing-subsequences/description/
 *
 * algorithms
 * Medium (38.86%)
 * Total Accepted:    18.8K
 * Total Submissions: 48.3K
 * Testcase Example:  '[4,6,7,7]'
 *
 *
 * Given an integer array, your task is to find all the different possible
 * increasing subsequences of the given array, and the length of an increasing
 * subsequence should be at least 2 .
 *
 *
 * Example:
 *
 * Input: [4, 6, 7, 7]
 * Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7],
 * [4,7,7]]
 *
 *
 *
 * Note:
 *
 * The length of the given array will not exceed 15.
 * The range of integer in the given array is [-100,100].
 * The given array may contain duplicates, and two equal integers should also
 * be considered as a special case of increasing sequence.
 *
 *
 */
class Solution {
    private void dfs(int index, int[] nums, List<Integer> tmp, Set<List<Integer>> res) {
        if (tmp.size() >= 2)
            res.add(new ArrayList(tmp));
        for (int i = index; i < nums.length; i++) {
            if (tmp.size() == 0 || tmp.get(tmp.size() - 1) <= nums[i]) {
                tmp.add(nums[i]);
                dfs(i + 1, nums, tmp, res);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        dfs(0, nums, new ArrayList<>(), res);
        return new ArrayList(res);
    }
}

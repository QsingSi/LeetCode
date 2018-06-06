import java.util.Map;

/*
 * [659] Split Array into Consecutive Subsequences
 *
 * https://leetcode.com/problems/split-array-into-consecutive-subsequences/description/
 *
 * algorithms
 * Medium (36.92%)
 * Total Accepted:    9.1K
 * Total Submissions: 24.7K
 * Testcase Example:  '[1,2,3,3,4,5]'
 *
 * You are given an integer array sorted in ascending order (may contain
 * duplicates), you need to split them into several subsequences, where each
 * subsequences consist of at least 3 consecutive integers. Return whether you
 * can make such a split.
 *
 * Example 1:
 *
 * Input: [1,2,3,3,4,5]
 * Output: True
 * Explanation:
 * You can split them into two consecutive subsequences :
 * 1, 2, 3
 * 3, 4, 5
 *
 *
 *
 * Example 2:
 *
 * Input: [1,2,3,3,4,4,5,5]
 * Output: True
 * Explanation:
 * You can split them into two consecutive subsequences :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 *
 *
 *
 * Example 3:
 *
 * Input: [1,2,3,4,4,5]
 * Output: False
 *
 *
 *
 * Note:
 *
 * The length of the input is in range of [1, 10000]
 *
 *
 */
class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> mask = new HashMap<>(), appendFreq = new HashMap<>();
        for (int i : nums)
            mask.put(i, mask.getOrDefault(i, 0) + 1);
        for (int i : nums) {
            if (mask.get(i) == 0)
                continue;
            else if (appendFreq.getOrDefault(i, 0) > 0) {
                appendFreq.put(i, appendFreq.get(i) - 1);
                appendFreq.put(i + 1, appendFreq.getOrDefault(i + 1, 0) + 1);
            } else if (mask.getOrDefault(i + 1, 0) > 0 && mask.getOrDefault(i + 2, 0) > 0) {
                mask.put(i + 1, mask.get(i + 1) - 1);
                mask.put(i + 2, mask.get(i + 2) - 1);
                appendFreq.put(i + 3, appendFreq.getOrDefault(i + 3, 0) + 1);
            } else return false;
            mask.put(i, mask.get(i) - 1);
        }
        return true;
    }
}

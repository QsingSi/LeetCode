import java.util.Random;
/*
 * [398] Random Pick Index
 *
 * https://leetcode.com/problems/random-pick-index/description/
 *
 * algorithms
 * Medium (44.85%)
 * Total Accepted:    35.6K
 * Total Submissions: 79.3K
 * Testcase Example:  '["Solution","pick"]\n[[[1,2,3,3,3]],[3]]'
 *
 *
 * Given an array of integers with possible duplicates, randomly output the
 * index of a given target number. You can assume that the given target number
 * must exist in the array.
 *
 *
 *
 * Note:
 * The array size can be very large. Solution that uses too much extra space
 * will not pass the judge.
 *
 *
 * Example:
 *
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 *
 * // pick(3) should return either index 2, 3, or 4 randomly. Each index should
 * have equal probability of returning.
 * solution.pick(3);
 *
 * // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
 * solution.pick(1);
 *
 *
 */
class Solution {

    Random rd;
    Map<Integer, List<Integer>> mask;
    public Solution(int[] nums) {
        rd = new Random();
        mask = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            mask.computeIfAbsent(nums[i], k->new ArrayList<>()).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> indexes = mask.get(target);
        int len = indexes.size();
        int randint = rd.nextInt(len);
        return indexes.get(randint);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */

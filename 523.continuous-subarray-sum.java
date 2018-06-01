/*
 * [523] Continuous Subarray Sum
 *
 * https://leetcode.com/problems/continuous-subarray-sum/description/
 *
 * algorithms
 * Medium (23.38%)
 * Total Accepted:    35.2K
 * Total Submissions: 150.4K
 * Testcase Example:  '[23,2,4,6,7]\n6'
 *
 *
 * Given a list of non-negative numbers and a target integer k, write a
 * function to check if the array has a continuous subarray of size at least 2
 * that sums up to the multiple of k, that is, sums up to n*k where n is also
 * an integer.
 *
 *
 *
 * Example 1:
 *
 * Input: [23, 2, 4, 6, 7],  k=6
 * Output: True
 * Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up
 * to 6.
 *
 *
 *
 *
 * Example 2:
 *
 * Input: [23, 2, 6, 4, 7],  k=6
 * Output: True
 * Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5
 * and sums up to 42.
 *
 *
 *
 * Note:
 *
 * The length of the array won't exceed 10,000.
 * You may assume the sum of all the numbers is in the range of a signed 32-bit
 * integer.
 *
 *
 */
class Solution {
    class SegmentTree {
        int sum;
        int start, end;
        SegmentTree left, right;
        public SegmentTree(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = this.right = null;
            this.sum = 0;
        }
    }

    SegmentTree rt = null;
    private SegmentTree buildTree(int[] nums, int start, int end) {
        if (start > end)
            return null;
        else {
            SegmentTree ret = new SegmentTree(start, end);
            if (start == end)
                ret.sum = nums[start];
            else {
                int mid = start + (end - start) / 2;
                ret.left = buildTree(nums, start, mid);
                ret.right = buildTree(nums, mid + 1, end);
                ret.sum = ret.left.sum + ret.right.sum;
            }
            return ret;
        }
    }
    private int query(SegmentTree rt, int start, int end) {
        if (start == rt.start && end == rt.end)
            return rt.sum;
        else {
            int mid = rt.start + (rt.end - rt.start) / 2;
            if (end <= mid)
                return query(rt.left, start, end);
            else if (start >= mid + 1)
                return query(rt.right, start, end);
            else
                return query(rt.left, start, mid) + query(rt.right, mid + 1, end);
        }
    }
    public boolean checkSubarraySum(int[] nums, int k) {
        rt = buildTree(nums, 0, nums.length - 1);
        for (int len = 2; len <= nums.length; len++) {
            for (int i = 0; i + len <= nums.length; i++) {
                int tmp = query(rt, i, i + len - 1);
                if (k == 0 && tmp == k)
                    return true;
                if (k != 0 && tmp % k == 0)
                    return true;
            }
        }
        return false;
    }
}

/*
 * [307] Range Sum Query - Mutable
 *
 * https://leetcode.com/problems/range-sum-query-mutable/description/
 *
 * algorithms
 * Medium (22.81%)
 * Total Accepted:    45.3K
 * Total Submissions: 198.5K
 * Testcase Example:  '["NumArray","sumRange","update","sumRange"]\n[[[1,3,5]],[0,2],[1,2],[0,2]]'
 *
 * Given an integer array nums, find the sum of the elements between indices i
 * and j (i ≤ j), inclusive.
 *
 * The update(i, val) function modifies nums by updating the element at index i
 * to val.
 *
 * Example:
 *
 * Given nums = [1, 3, 5]
 *
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 *
 *
 *
 * Note:
 *
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is
 * distributed evenly.
 *
 *
 */
class NumArray {

    class SegmentTree {
        int start, end;
        SegmentTree left, right;
        int sum;

        public SegmentTree(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = this.right = null;
            this.sum = 0;
        }
    }

    SegmentTree root = null;

    private SegmentTree buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else {
            SegmentTree ret = new SegmentTree(start, end);
            if (start == end) {
                ret.sum = nums[start];
            } else {
                int mid = start + (end - start) / 2;
                ret.left = buildTree(nums, start, mid);
                ret.right = buildTree(nums, mid + 1, end);
                ret.sum = ret.left.sum + ret.right.sum;
            }
            return ret;
        }
    }

    private void update(SegmentTree root, int pos, int val) {
        if (root.start == root.end)
            root.sum = val;
        else {
            int mid = root.start + (root.end - root.start) / 2;
            if (pos <= mid)
                update(root.left, pos, val);
            else
                update(root.right, pos, val);
            root.sum = root.left.sum + root.right.sum;
        }
    }

    private int sumRange(SegmentTree root, int start, int end) {
        if (end == root.end && start == root.start)
            return root.sum;
        else {
            int mid = root.start + (root.end - root.start) / 2;
            if (end <= mid)
                return sumRange(root.left, start, end);
            else if (start >= mid + 1)
                return sumRange(root.right, start, end);
            else
                return sumRange(root.left, start, mid) + sumRange(root.right, mid + 1, end);
        }
    }
    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }

    public void update(int i, int val) {
        update(root, i, val);
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */

/*
 * [404] Sum of Left Leaves
 *
 * https://leetcode.com/problems/sum-of-left-leaves/description/
 *
 * algorithms
 * Easy (47.62%)
 * Total Accepted:    87.7K
 * Total Submissions: 184.2K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 *
 * There are two left leaves in the binary tree, with values 9 and 15
 * respectively. Return 24.
 *
 *
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int sum = 0;
    public void dfs(TreeNode rt, boolean mask) {
        if (rt == null)
            return;
        if (rt.left == null && rt.right == null && mask)
            sum += rt.val;
        if (rt.left != null)
            dfs(rt.left, true);
        if (rt.right != null)
            dfs(rt.right, false);
    }
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root, false);
        return sum;
    }
}

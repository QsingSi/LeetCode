/*
 * [513] Find Bottom Left Tree Value
 *
 * https://leetcode.com/problems/find-bottom-left-tree-value/description/
 *
 * algorithms
 * Medium (56.16%)
 * Total Accepted:    45.6K
 * Total Submissions: 81.1K
 * Testcase Example:  '[2,1,3]'
 *
 *
 * Given a binary tree, find the leftmost value in the last row of the tree.
 *
 *
 * Example 1:
 *
 * Input:
 *
 * ⁠   2
 * ⁠  / \
 * ⁠ 1   3
 *
 * Output:
 * 1
 *
 *
 *
 * ⁠ Example 2:
 *
 * Input:
 *
 * ⁠       1
 * ⁠      / \
 * ⁠     2   3
 * ⁠    /   / \
 * ⁠   4   5   6
 * ⁠      /
 * ⁠     7
 *
 * Output:
 * 7
 *
 *
 *
 * Note:
 * You may assume the tree (i.e., the given root node) is not NULL.
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
    public int res = 0;
    private int getHeight(TreeNode rt) {
        if (rt == null)
            return 0;
        return Math.max(getHeight(rt.left), getHeight(rt.right)) + 1;
    }
    private void dfs(TreeNode rt, int height, int now) {
        if (rt == null)
            return;
        if (now == height - 1) {
            if (rt.left != null) {
                res = rt.left.val;
                return;
            }
            if (rt.right != null) {
                res = rt.right.val;
                return;
            }
        }
        dfs(rt.right, height, now + 1);
        dfs(rt.left, height, now + 1);
    }
    public int findBottomLeftValue(TreeNode root) {
        int height = getHeight(root);
        if (height == 1)
            return root.val;
        dfs(root, height, 1);
        return res;
    }
}

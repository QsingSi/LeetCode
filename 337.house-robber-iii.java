/*
 * [337] House Robber III
 *
 * https://leetcode.com/problems/house-robber-iii/description/
 *
 * algorithms
 * Medium (44.88%)
 * Total Accepted:    66K
 * Total Submissions: 147K
 * Testcase Example:  '[3,2,3,null,3,null,1]'
 *
 *
 * The thief has found himself a new place for his thievery again. There is
 * only one entrance to this area, called the "root." Besides the root, each
 * house has one and only one parent house. After a tour, the smart thief
 * realized that "all houses in this place forms a binary tree". It will
 * automatically contact the police if two directly-linked houses were broken
 * into on the same night.
 *
 *
 *
 * Determine the maximum amount of money the thief can rob tonight without
 * alerting the police.
 *
 *
 * Example 1:
 *
 * ⁠    3
 * ⁠   / \
 * ⁠  2   3
 * ⁠   \   \
 * ⁠    3   1
 *
 * Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 *
 *
 * Example 2:
 *
 * ⁠    3
 * ⁠   / \
 * ⁠  4   5
 * ⁠ / \   \
 * ⁠1   3   1
 *
 * Maximum amount of money the thief can rob = 4 + 5 = 9.
 *
 *
 * Credits:Special thanks to @dietpepsi for adding this problem and creating
 * all test cases.
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
    private int dfs(TreeNode rt, Map<TreeNode, Integer> mask) {
        if (rt == null)
            return 0;
        if (mask.containsKey(rt))
            return mask.get(rt);
        int val = 0;
        if (rt.left != null) {
            val += dfs(rt.left.left, mask) + dfs(rt.left.right, mask);
        }
        if (rt.right != null) {
            val += dfs(rt.right.left, mask) + dfs(rt.right.right, mask);
        }
        val = Math.max(val + rt.val, dfs(rt.left, mask) + dfs(rt.right, mask));
        mask.put(rt, val);
        return val;
    }
    public int rob(TreeNode root) {
        return dfs(root, new HashMap());
    }
}

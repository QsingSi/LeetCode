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
    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        int odd = 0, even = 0;
        Queue<TreeNode> q = new LinkedList();
        Map<TreeNode, Integer> mask = new HashMap();
        mask.put(root, 0);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode top = q.remove();
            int height = mask.get(top);
            if (height % 2 == 0)
                even += top.val;
            else
                odd += top.val;
            if (top.left != null) {
                mask.put(top.left, height + 1);
                q.add(top.left);
            }
            if (top.right != null) {
                mask.put(top.right, height + 1);
                q.add(top.right);
            }
        }
        return Math.max(odd, even);
    }
}

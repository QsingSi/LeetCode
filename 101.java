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
    public boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if ((left == null || right == null) || (left.val != right.val))
            return false;
        return dfs(left.left, right.right) & dfs(left.right, right.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return root == null || dfs(root.left, root.right);
    }
}
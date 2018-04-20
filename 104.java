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
    public int dfs(TreeNode rt) {
        if (rt == null)
            return 0;
        return Math.max(1 + dfs(rt.left), 1 + dfs(rt.right));
    }

    public int maxDepth(TreeNode root) {
        return dfs(root);
    }
}
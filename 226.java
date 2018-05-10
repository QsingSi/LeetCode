/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public void dfs(TreeNode rt) {
        if (rt == null)
            return;
        TreeNode tmp = rt.left;
        rt.left = rt.right;
        rt.right = tmp;
        dfs(rt.left);
        dfs(rt.right);
    }

    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }
}
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode dfs(TreeNode rt, TreeNode p, TreeNode q) {
        if (rt.val >= p.val && rt.val <= q.val)
            return rt;
        if (rt.val <= p.val && rt.val >= q.val)
            return rt;
        if (rt.val < p.val)
            return dfs(rt.right, p, q);
        return dfs(rt.left, p, q);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }
}
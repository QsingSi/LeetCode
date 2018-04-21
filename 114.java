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
    public TreeNode dfs(TreeNode rt) {
        if (rt.left == null)
            return rt;
        TreeNode tmp = rt.right;
        rt.right = dfs(rt.left);
        rt.left = null;
        TreeNode rr = rt.right;
        while (rr.right != null)
            rr = rr.right;
        if (tmp != null)
            rr.right = dfs(tmp);
        return rt;
    }

    public void flatten(TreeNode root) {
        TreeNode tmp = root;
        while (tmp != null) {
            tmp = dfs(tmp);
            tmp = tmp.right;
        }
    }
}
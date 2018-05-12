/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public void dfs(TreeNode rt, List<String> res, String tmp) {
        if (rt == null)
            return;
        if (rt.left == null && rt.right == null) {
            res.add(tmp + Integer.toString(rt.val));
        }
        if (rt.left != null)
            dfs(rt.left, res, tmp + Integer.toString(rt.val) + "->");
        if (rt.right != null)
            dfs(rt.right, res, tmp + Integer.toString(rt.val) + "->");
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, res, "");
        return res;
    }
}
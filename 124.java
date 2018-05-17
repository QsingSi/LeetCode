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
    public int ans;

    public int dfs(TreeNode rt) {
        if (rt == null)
            return 0;
        int left = dfs(rt.left);
        int right = dfs(rt.right);

        int maxPath = 0, toReturn = 0;
        if (left <= 0 && right <= 0) {
            maxPath = rt.val;
            toReturn = rt.val;
        } else if (left <= 0) {
            maxPath = rt.val + right;
            toReturn = rt.val + right;
        } else if (right <= 0) {
            maxPath = rt.val + left;
            toReturn = rt.val + left;
        } else {
            maxPath = rt.val + left + right;
            toReturn = rt.val + Math.max(left, right);
        }
        ans = Math.max(ans, maxPath);
        return toReturn;
    }

    public int maxPathSum(TreeNode root) {
        if (root != null)
            ans = root.val;
        dfs(root);
        return ans;
    }
}
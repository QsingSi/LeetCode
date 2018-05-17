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
    public boolean judge(TreeNode rt, int sum) {
        if (rt == null)
            return false;
        if (rt.left == null && rt.right == null) {
            if (sum == rt.val)
                return true;
            else
                return false;
        }
        if (judge(rt.left, sum - rt.val))
            return true;
        else if (judge(rt.right, sum - rt.val))
            return true;
        else
            return false;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return judge(root, sum);
    }
}
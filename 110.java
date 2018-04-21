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
    public boolean judge(TreeNode rt) {
        if (rt == null)
            return true;
        if (Math.abs(getHeight(rt.left) - getHeight(rt.right)) <= 1) {
            if (judge(rt.left) && judge(rt.right))
                return true;
            return false;
        }
        return false;
    }

    public int getHeight(TreeNode rt) {
        if (rt == null)
            return 0;
        return Math.max(1 + getHeight(rt.left), 1 + getHeight(rt.right));
    }

    public boolean isBalanced(TreeNode root) {
        return judge(root);
    }
}
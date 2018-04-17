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
    public boolean judge(TreeNode a, TreeNode b) {
        if (a == null && b == null)
            return true;
        if (a == null || b == null || a.val != b.val)
            return false;
        else
            return judge(a.left, b.left) & judge(a.right, b.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return judge(p, q);
    }
}
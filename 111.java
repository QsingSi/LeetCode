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
    public int min = 10000;

    public void depth(TreeNode rt, int level) {
        if (rt == null)
            return;
        if (rt.left == null && rt.right == null) {
            if (level < min)
                min = level;
            return;
        }
        depth(rt.left, level + 1);
        depth(rt.right, level + 1);
    }

    public int minDepth(TreeNode root) {
        depth(root, 1);
        return root == null ? 0 : min;
    }
}
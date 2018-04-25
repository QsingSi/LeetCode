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
    public int sum = 0;

    public void dfs(TreeNode rt, int now) {
        now = now * 10 + rt.val;
        if (rt.left == null && rt.right == null) {
            System.out.println(now);
            sum += now;
            return;
        }
        if (rt.left != null)
            dfs(rt.left, now);
        if (rt.right != null)
            dfs(rt.right, now);
    }

    public int sumNumbers(TreeNode root) {
        if (root != null)
            dfs(root, 0);
        return sum;
    }
}
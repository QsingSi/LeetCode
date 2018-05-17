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
    public void postorder(TreeNode rt, List<Integer> tmp) {
        if (rt == null)
            return;
        postorder(rt.left, tmp);
        postorder(rt.right, tmp);
        tmp.add(rt.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }
}
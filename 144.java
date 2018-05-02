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
    public void preorder(TreeNode rt, List<Integer> tmp) {
        if (rt == null)
            return;
        tmp.add(rt.val);
        preorder(rt.left, tmp);
        preorder(rt.right, tmp);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> tmp = new ArrayList<>();
        preorder(root, tmp);
        return tmp;
    }
}
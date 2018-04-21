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
    public TreeNode build(int[] inorder, int[] postorder, int instart, int inend, int poststart, int postend) {
        if (poststart > postend)
            return null;
        if (poststart == postend) {
            TreeNode rt = new TreeNode(postorder[poststart]);
            return rt;
        }
        int k = instart;
        for (; k <= inend; k++)
            if (inorder[k] == postorder[postend])
                break;
        TreeNode root = new TreeNode(inorder[k]);
        root.left = build(inorder, postorder, instart, k - 1, poststart, poststart + k - instart - 1);
        root.right = build(inorder, postorder, k + 1, inend, poststart + k - instart, postend - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
}
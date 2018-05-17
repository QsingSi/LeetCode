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
    public TreeNode build(int[] preorder, int[] inorder, int prestart, int prend, int instart, int inend) {
        if (prestart > prend)
            return null;
        if (prestart == prend) {
            TreeNode rt = new TreeNode(preorder[prestart]);
            return rt;
        }
        int k = instart;
        for (; k <= inend; k++)
            if (inorder[k] == preorder[prestart])
                break;
        TreeNode root = new TreeNode(preorder[prestart]);
        root.left = build(preorder, inorder, prestart + 1, prestart + k - instart, instart, k - 1);
        root.right = build(preorder, inorder, prestart + k - instart + 1, prend, k + 1, inend);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
}
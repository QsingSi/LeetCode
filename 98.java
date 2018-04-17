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
    public List<Integer> arr = new ArrayList<Integer>();

    public void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        arr.add(root.val);
        inorder(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        inorder(root);
        boolean mark = true;
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i) >= arr.get(i + 1)) {
                mark = false;
            }
        }
        return mark;
    }
}
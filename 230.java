/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public void inorder(TreeNode rt, List<Integer> tmp) {
        if (rt == null)
            return;
        inorder(rt.left, tmp);
        tmp.add(rt.val);
        inorder(rt.right, tmp);
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> tmp = new ArrayList<>();
        inorder(root, tmp);
        return tmp.get(k - 1);
    }
}
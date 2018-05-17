/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public int height(TreeNode rt) {
        if (rt == null)
            return -1;
        return 1 + height(rt.left);
    }

    public int countNodes(TreeNode root) {
        int sum = 0;
        int h = height(root);
        while (root != null) {
            if (h - 1 == height(root.right)) {
                sum += 1 << h;
                root = root.right;
            } else {
                sum += 1 << h - 1;
                root = root.left;
            }
            h--;
        }
        return sum;
    }
}
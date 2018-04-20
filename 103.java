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
    public void preOrder(TreeNode rt, int level, List<List<Integer>> res) {
        if (rt == null)
            return;
        if (level >= res.size()) {
            List<Integer> tmp = new ArrayList<>();
            res.add(tmp);
        }
        if (level % 2 == 0)
            res.get(level).add(rt.val);
        else
            res.get(level).add(0, rt.val);
        preOrder(rt.left, level + 1, res);
        preOrder(rt.right, level + 1, res);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        preOrder(root, 0, res);
        return res;
    }
}
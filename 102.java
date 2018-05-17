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
        if (level < res.size()) {
            res.get(level).add(rt.val);
        } else {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(rt.val);
            res.add(tmp);
        }
        preOrder(rt.left, level + 1, res);
        preOrder(rt.right, level + 1, res);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        preOrder(root, 0, res);
        return res;
    }
}
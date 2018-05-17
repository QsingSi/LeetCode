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
    public void dfs(TreeNode rt, int level, List<List<Integer>> res) {
        if (rt == null)
            return;
        if (level >= res.size())
            res.add(0, new ArrayList<Integer>());
        res.get(res.size() - level - 1).add(rt.val);
        dfs(rt.left, level + 1, res);
        dfs(rt.right, level + 1, res);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }
}
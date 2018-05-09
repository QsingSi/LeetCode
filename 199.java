/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public void dfs(TreeNode rt, List<Integer> res, int height) {
        if (rt == null)
            return;
        if (height >= res.size()) {
            res.add(rt.val);
        }
        dfs(rt.right, res, height + 1);
        dfs(rt.left, res, height + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }
}
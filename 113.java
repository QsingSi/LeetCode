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
    public void judge(TreeNode rt, int sum, List<List<Integer>> res, List<Integer> tmp) {
        if (rt == null) {
            return;
        }
        if (rt.left == null && rt.right == null) {
            if (sum == rt.val) {
                tmp.add(rt.val);
                res.add(new ArrayList(tmp));
                tmp.remove(tmp.size() - 1);
                return;
            } else {
                return;
            }
        }
        tmp.add(rt.val);
        judge(rt.left, sum - rt.val, res, tmp);
        judge(rt.right, sum - rt.val, res, tmp);
        tmp.remove(tmp.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        judge(root, sum, res, new ArrayList<Integer>());
        return res;
    }
}

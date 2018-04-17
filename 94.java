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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null)
            return res;
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode tmp = root;
        while (tmp != null) {
            st.push(tmp);
            tmp = tmp.left;
        }
        TreeNode top;
        while (!st.empty()) {
            top = st.pop();
            res.add(top.val);
            if (top.right != null) {
                tmp = top.right;
                while (tmp != null) {
                    st.push(tmp);
                    tmp = tmp.left;
                }
            }
        }
        return res;
    }
}
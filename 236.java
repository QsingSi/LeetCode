/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> mask = new HashMap<>();
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        mask.put(root, root);
        while (!Q.isEmpty()) {
            TreeNode top = Q.remove();
            if (top.left != null) {
                mask.put(top.left, top);
                Q.add(top.left);
            }
            if (top.right != null) {
                mask.put(top.right, top);
                Q.add(top.right);
            }
        }
        TreeNode p_pre = p;
        TreeNode q_pre = q;
        while (p_pre != root) {
            q_pre = q;
            while (q_pre != root) {
                if (q_pre == p_pre)
                    return p_pre;
                q_pre = mask.get(q_pre);
            }
            p_pre = mask.get(p_pre);
        }
        return root;
    }
}
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void dfs(TreeLinkNode lchild, TreeLinkNode rchild) {
        if (lchild == null && rchild == null)
            return;
        if (lchild != null) {
            if (rchild != null)
                lchild.next = rchild;
            if (lchild.left != null || lchild.right != null) {
                if (lchild.right != null)
                    lchild.right.next = rchild.left == null ? rchild.right : rchild.left;
                else
                    lchild.left.next = rchild.left == null ? rchild.right : rchild.left;
            }
        }
        dfs(lchild.left, lchild.right);
        dfs(lchild.right, rchild.left);
        dfs(rchild.left, rchild.right);
    }

    public void connect(TreeLinkNode root) {
        if (root != null)
            dfs(root.left, root.right);
    }
}
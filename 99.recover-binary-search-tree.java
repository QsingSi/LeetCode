/*
 * [99] Recover Binary Search Tree
 *
 * https://leetcode.com/problems/recover-binary-search-tree/description/
 *
 * algorithms
 * Hard (31.25%)
 * Total Accepted:    89.3K
 * Total Submissions: 285.6K
 * Testcase Example:  '[1,3,null,null,2]'
 *
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 *
 * Example 1:
 *
 *
 * Input: [1,3,null,null,2]
 *
 * 1
 * /
 * 3
 * \
 * 2
 *
 * Output: [3,1,null,null,2]
 *
 * 3
 * /
 * 1
 * \
 * 2
 *
 *
 * Example 2:
 *
 *
 * Input: [3,1,4,null,null,2]
 *
 * ⁠ 3
 * ⁠/ \
 * 1   4
 * /
 * 2
 *
 * Output: [2,1,4,null,null,3]
 *
 * ⁠ 2
 * ⁠/ \
 * 1   4
 * /
 * ⁠ 3
 *
 *
 * Follow up:
 *
 *
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
 *
 *
 */
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
    TreeNode firstElement = null;
    TreeNode secordElement = null;
    TreeNode preElement = new TreeNode(Integer.MIN_VALUE);
    public void dfs(TreeNode rt) {
        if (rt == null)
            return;
        dfs(rt.left);
        if (firstElement == null && preElement.val >= rt.val)
            firstElement = preElement;
        if (firstElement != null && preElement.val >= rt.val)
            secordElement = rt;
        preElement = rt;
        dfs(rt.right);
    }
    public void recoverTree(TreeNode root) {
        dfs(root);
        int tmp = firstElement.val;
        firstElement.val = secordElement.val;
        secordElement.val = tmp;
    }
}

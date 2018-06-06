/*
 * [662] Maximum Width of Binary Tree
 *
 * https://leetcode.com/problems/maximum-width-of-binary-tree/description/
 *
 * algorithms
 * Medium (38.18%)
 * Total Accepted:    14.9K
 * Total Submissions: 38.9K
 * Testcase Example:  '[1,3,2,5,3,null,9]'
 *
 * Given a binary tree, write a function to get the maximum width of the given
 * tree. The width of a tree is the maximum width among all levels. The binary
 * tree has the same structure as a full binary tree, but some nodes are
 * null.
 *
 * The width of one level is defined as the length between the end-nodes (the
 * leftmost and right most non-null nodes in the level, where the null nodes
 * between the end-nodes are also counted into the length calculation.
 *
 * Example 1:
 *
 * Input:
 *
 * ⁠          1
 * ⁠        /   \
 * ⁠       3     2
 * ⁠      / \     \
 * ⁠     5   3     9
 *
 * Output: 4
 * Explanation: The maximum width existing in the third level with the length 4
 * (5,3,null,9).
 *
 *
 *
 * Example 2:
 *
 * Input:
 *
 * ⁠         1
 * ⁠        /
 * ⁠       3
 * ⁠      / \
 * ⁠     5   3
 *
 * Output: 2
 * Explanation: The maximum width existing in the third level with the length 2
 * (5,3).
 *
 *
 *
 * Example 3:
 *
 * Input:
 *
 * ⁠         1
 * ⁠        / \
 * ⁠       3   2
 * ⁠      /
 * ⁠     5
 *
 * Output: 2
 * Explanation: The maximum width existing in the second level with the length
 * 2 (3,2).
 *
 *
 * Example 4:
 *
 * Input:
 *
 * ⁠         1
 * ⁠        / \
 * ⁠       3   2
 * ⁠      /     \
 * ⁠     5       9
 * ⁠    /         \
 * ⁠   6           7
 * Output: 8
 * Explanation:The maximum width existing in the fourth level with the length 8
 * (6,null,null,null,null,null,null,7).
 *
 *
 *
 *
 * Note:
 * Answer will in the range of 32-bit signed integer.
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
    private int helper(TreeNode rt, int level, int index, List<Integer> start, List<Integer> end) {
        if (rt == null)
            return 0;
        if (start.size() == level) {
            start.add(index);
            end.add(index);
        } else end.set(level, index);
        int cur = end.get(level) - start.get(level) + 1;
        int left = helper(rt.left, level + 1, 2 * index, start, end);
        int right = helper(rt.right, level + 1, 2 * index + 1, start, end);
        return Math.max(cur, Math.max(left, right));
    }
    public int widthOfBinaryTree(TreeNode root) {
        return helper(root, 0, 1, new ArrayList<>(), new ArrayList<>());
    }
}

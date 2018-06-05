/*
 * [652] Find Duplicate Subtrees
 *
 * https://leetcode.com/problems/find-duplicate-subtrees/description/
 *
 * algorithms
 * Medium (37.18%)
 * Total Accepted:    14.9K
 * Total Submissions: 40.1K
 * Testcase Example:  '[2,1,1]'
 *
 *
 * Given a binary tree, return all duplicate subtrees. For each kind of
 * duplicate subtrees, you only need to return the root node of any one of
 * them.
 *
 *
 * Two trees are duplicate if they have the same structure with same node
 * values.
 *
 *
 * Example 1:
 *
 * ⁠       1
 * ⁠      / \
 * ⁠     2   3
 * ⁠    /   / \
 * ⁠   4   2   4
 * ⁠      /
 * ⁠     4
 *
 * The following are two duplicate subtrees:
 *
 * ⁠     2
 * ⁠    /
 * ⁠   4
 *
 * and
 *
 * ⁠   4
 *
 * Therefore, you need to return above trees' root in the form of a list.
 *
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
    private String serialize(TreeNode node, Map<String, List<TreeNode>> mask) {
        if (node == null)
            return "";
        String s = "(" + serialize(node.left, mask) + node.val + serialize(node.right, mask) + ")";
        mask.computeIfAbsent(s, k->new ArrayList<>()).add(node);
        return s;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, List<TreeNode>> mask = new HashMap<>();
        List<TreeNode> res = new ArrayList<>();
        serialize(root, mask);
        for (List<TreeNode> duls : mask.values())
            if (duls.size() > 1)
                res.add(duls.get(0));
        return res;
    }
}

import java.util.List;
import java.util.Queue;
/*
 * [764] N-ary Tree Level Order Traversal
 *
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/description/
 *
 * algorithms
 * Easy (1.13%)
 * Total Accepted:    1K
 * Total Submissions: 3.1K
 * Testcase Example:  '{"$id":"1","children":[{"$id":"2","children":[{"$id":"5","children":[],"val":5},{"$id":"6","children":[],"val":6}],"val":3},{"$id":"3","children":[],"val":2},{"$id":"4","children":[],"val":4}],"val":1}'
 *
 * Given an n-ary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 *
 * For example, given a 3-ary tree:
 *
 *
 *
 *
 *
 * We should return its level order traversal:
 *
 *
 *
 *
 *
 *
 * [
 * ⁠    [1],
 * ⁠    [3,2,4],
 * ⁠    [5,6]
 * ]
 *
 *
 *
 *
 * Note:
 *
 *
 * The depth of the tree is at most 1000.
 * The total number of nodes is at most 5000.
 *
 *
 *
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    class TreeNode {
        int level;
        Node node;
        public TreeNode(int level, Node node) {
            this.level = level;
            this.node = node;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(new TreeNode(0, root));
        while (!q.isEmpty()) {
            TreeNode top = q.poll();
            int h = top.level;
            if (res.size() <= h) res.add(new ArrayList<>());
            res.get(h).add(top.node.val);
            for (Node node : top.node.children)
                q.add(new TreeNode(h + 1, node));
        }
        return res;
    }
}

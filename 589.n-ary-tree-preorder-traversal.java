import java.util.Stack;
/*
 * [775] N-ary Tree Preorder Traversal
 *
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/
 *
 * algorithms
 * Easy (0.43%)
 * Total Accepted:    1K
 * Total Submissions: 3.8K
 * Testcase Example:  '{"$id":"1","children":[{"$id":"2","children":[{"$id":"5","children":[],"val":5},{"$id":"6","children":[],"val":6}],"val":3},{"$id":"3","children":[],"val":2},{"$id":"4","children":[],"val":4}],"val":1}'
 *
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 *
 *
 * For example, given a 3-ary tree:
 *
 *
 *
 *
 * Return its preorder traversal as: [1,3,5,6,2,4].
 *
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
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
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Node> st = new Stack<>();
        st.add(root);
        while (!st.isEmpty()) {
            Node top = st.pop();
            res.add(top.val);
            for (int i = top.children.size() - 1; i >= 0; i--)
                st.add(top.children.get(i));
        }
        return res;
    }
}

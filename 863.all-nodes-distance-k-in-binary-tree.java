import java.util.*;
/*
 * [893] All Nodes Distance K in Binary Tree
 *
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
 *
 * algorithms
 * Medium (39.72%)
 * Total Accepted:    4.3K
 * Total Submissions: 10.8K
 * Testcase Example:  '[3,5,1,6,2,0,8,null,null,7,4]\n5\n2'
 *
 * We are given a binary tree (with root node root), a target node, and an
 * integer value K.
 *
 * Return a list of the values of all nodes that have a distance K from the
 * target node.  The answer can be returned in any order.
 *
 *
 *
 *
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 *
 * Output: [7,4,1]
 *
 * Explanation:
 * The nodes that are a distance 2 from the target node (with value 5)
 * have values 7, 4, and 1.
 *
 *
 *
 * Note that the inputs "root" and "target" are actually TreeNodes.
 * The descriptions of the inputs above are just serializations of these
 * objects.
 *
 *
 *
 *
 * Note:
 *
 *
 * The given tree is non-empty.
 * Each node in the tree has unique values 0 <= node.val <= 500.
 * The target node is a node in the tree.
 * 0 <= K <= 1000.
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
    class Node {
        TreeNode node;
        TreeNode pre;
        int dis;
        public Node(TreeNode node, int dis) {
            this.node = node;
            this.pre = node;
            this.dis = dis;
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        helper(target, res, 0, K);
        return res;
    }

    private void helper(TreeNode node, List<Integer> res, int dis, int K) {
        if (dis > K || node == null)
            return;
        if (dis == K) {
            res.add(node.val);
            return;
        }
        helper(node.left, res, dis + 1, K);
        helper(node.right, res, dis + 1, K);
    }
}

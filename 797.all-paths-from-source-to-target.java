/*
 * [813] All Paths From Source to Target
 *
 * https://leetcode.com/problems/all-paths-from-source-to-target/description/
 *
 * algorithms
 * Medium (67.93%)
 * Total Accepted:    8.3K
 * Total Submissions: 12.3K
 * Testcase Example:  '[[1,2],[3],[3],[]]'
 *
 * Given a directed, acyclic graph of N nodes.  Find all possible paths from
 * node 0 to node N-1, and return them in any order.
 *
 * The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.
 * graph[i] is a list of all nodes j for which the edge (i, j) exists.
 *
 *
 * Example:
 * Input: [[1,2], [3], [3], []]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: The graph looks like this:
 * 0--->1
 * |    |
 * v    v
 * 2--->3
 * There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 *
 *
 * Note:
 *
 *
 * The number of nodes in the graph will be in the range [2, 15].
 * You can print different paths in any order, but you should keep the order of
 * nodes inside one path.
 *
 *
 */
class Solution {
    private void helper(int[][] graph, int now, List<List<Integer>> res, List<Integer> path) {
        if (now == graph.length - 1) {
            res.add(new ArrayList(path));
            return;
        }
        for (int v : graph[now]) {
            path.add(v);
            helper(graph, v, res, path);
            path.remove(path.size() - 1);
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        helper(graph, 0, res, path);
        return res;
    }
}

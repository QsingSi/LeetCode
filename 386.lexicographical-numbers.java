import java.util.PriorityQueue;

/*
 * [386] Lexicographical Numbers
 *
 * https://leetcode.com/problems/lexicographical-numbers/description/
 *
 * algorithms
 * Medium (42.43%)
 * Total Accepted:    29.1K
 * Total Submissions: 68.5K
 * Testcase Example:  '13'
 *
 *
 * Given an integer n, return 1 - n in lexicographical order.
 *
 *
 *
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 *
 *
 *
 * Please optimize your algorithm to use less time and space. The input size
 * may be as large as 5,000,000.
 *
 */
class Solution {
    public void dfs(List<Integer> res, int n, int cur) {
        if (cur > n)
            return;
        res.add(cur);
        if (cur * 10 <= n)
            dfs(res, n, cur * 10);
        if (cur + 1 <= n && cur % 10 != 9)
            dfs(res, n, cur + 1);
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList();
        dfs(res, n, 1);
        return res;
    }
}

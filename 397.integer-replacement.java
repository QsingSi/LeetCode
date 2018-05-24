import java.util.Map;

/*
 * [397] Integer Replacement
 *
 * https://leetcode.com/problems/integer-replacement/description/
 *
 * algorithms
 * Medium (30.46%)
 * Total Accepted:    29.8K
 * Total Submissions: 97.9K
 * Testcase Example:  '8'
 *
 *
 * Given a positive integer n and you can do operations as follow:
 *
 *
 *
 *
 * If n is even, replace n with n/2.
 * If n is odd, you can replace n with either n + 1 or n - 1.
 *
 *
 *
 *
 * What is the minimum number of replacements needed for n to become 1?
 *
 *
 *
 *
 * Example 1:
 *
 * Input:
 * 8
 *
 * Output:
 * 3
 *
 * Explanation:
 * 8 -> 4 -> 2 -> 1
 *
 *
 *
 * Example 2:
 *
 * Input:
 * 7
 *
 * Output:
 * 4
 *
 * Explanation:
 * 7 -> 8 -> 4 -> 2 -> 1
 * or
 * 7 -> 6 -> 3 -> 2 -> 1
 *
 *
 */
class Solution {
    private int dfs(int n, Map<Integer, Integer> mask) {
        if (mask.containsKey(n))
            return mask.get(n);
        if (n == 1)
            return 0;
        if (n % 2 == 0) {
            int val = 1 + dfs(n / 2, mask);
            mask.put(n, val);
            return val;
        }
        if (n == Integer.MAX_VALUE) {
            int val = 32;
            mask.put(n, val);
            return val;
        }
        int val =  Math.min(1 + dfs(n - 1, mask), 1 + dfs(n + 1, mask));
        mask.put(n, val);
        return val;
    }
    public int integerReplacement(int n) {
        Map<Integer, Integer> mask = new HashMap<>();
        mask.put(1, 0);
        return dfs(n, mask);
    }
}

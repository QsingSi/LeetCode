import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * [399] Evaluate Division
 *
 * https://leetcode.com/problems/evaluate-division/description/
 *
 * algorithms
 * Medium (42.63%)
 * Total Accepted:    31.1K
 * Total Submissions: 72.9K
 * Testcase Example:  '[ ["a","b"],["b","c"] ]\n[2.0,3.0]\n[ ["a","c"],["b","c"],["a","e"],["a","a"],["x","x"] ]'
 *
 *
 * Equations are given in the format A / B = k, where  A and B are variables
 * represented as strings, and k is a real number (floating point number).
 * Given some queries, return the answers. If the answer does not exist, return
 * -1.0.
 *
 * Example:
 * Given  a / b = 2.0, b / c = 3.0. queries are:  a / c = ?,  b / a = ?, a / e
 * = ?,  a / a = ?, x / x = ? . return  [6.0, 0.5, -1.0, 1.0, -1.0 ].
 *
 *
 * The input is:  vector<pair<string, string>> equations, vector<double>&
 * values, vector<pair<string, string>> queries , where equations.size() ==
 * values.size(), and the values are positive. This represents the equations.
 * Return  vector<double>.
 *
 *
 * According to the example above:
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"]
 * ].
 *
 *
 *
 * The input is always valid. You may assume that evaluating the queries will
 * result in no division by zero and there is no contradiction.
 *
 */
class Solution {
    public double dfs(Map<String, List<String>> mask, String now, String target, double res, Map<String, Double> div, Map<String, Integer> visit) {
        if (!mask.containsKey(now) || !mask.containsKey(target))
            return -1.0;
        if (now.equals(target))
            return res;
        if (div.containsKey(now + target))
            return res * div.get(now + target);
        visit.put(now, 1);
        double val = -1.0;
        for (String ch : mask.get(now)) {
            if (visit.containsKey(ch))
                continue;
            val =  dfs(mask, ch, target, res * div.get(now + ch), div, visit);
            if (val != -1.0)
                break;
        }
        div.put(now + target, val);
        return val;
    }
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Double> div = new HashMap<>();
        Map<String, List<String>> mask = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            div.put(equations[i][0] + equations[i][1], values[i]);
            div.put(equations[i][1] + equations[i][0], 1 / values[i]);
            div.put(equations[i][0] + equations[i][0], 1.0);
            div.put(equations[i][1] + equations[i][1], 1.0);
            mask.computeIfAbsent(equations[i][0], k->new ArrayList<>()).add(equations[i][1]);
            mask.computeIfAbsent(equations[i][1], k->new ArrayList<>()).add(equations[i][0]);
        }
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (!mask.containsKey(queries[i][0]) || !mask.containsKey(queries[i][1]))
                res[i] = -1.0;
            else
                res[i] = dfs(mask, queries[i][0], queries[i][1], 1.0, div, new HashMap<>());
        }
        return res;
    }
}

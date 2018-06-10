import java.util.Map;

/*
 * [677] Map Sum Pairs
 *
 * https://leetcode.com/problems/map-sum-pairs/description/
 *
 * algorithms
 * Medium (51.37%)
 * Total Accepted:    13K
 * Total Submissions: 25.4K
 * Testcase Example:  '["MapSum", "insert", "sum", "insert", "sum"]\n[[], ["apple",3], ["ap"], ["app",2], ["ap"]]'
 *
 *
 * Implement a MapSum class with insert, and sum methods.
 *
 *
 *
 * For the method insert, you'll be given a pair of (string, integer). The
 * string represents the key and the integer represents the value. If the key
 * already existed, then the original key-value pair will be overridden to the
 * new one.
 *
 *
 *
 * For the method sum, you'll be given a string representing the prefix, and
 * you need to return the sum of all the pairs' value whose key starts with the
 * prefix.
 *
 *
 * Example 1:
 *
 * Input: insert("apple", 3), Output: Null
 * Input: sum("ap"), Output: 3
 * Input: insert("app", 2), Output: Null
 * Input: sum("ap"), Output: 5
 *
 *
 *
 */
class MapSum {

    Map<String, Integer> mask;
    Set<String> set;
    /** Initialize your data structure here. */
    public MapSum() {
        mask = new HashMap<>();
        set = new HashSet<>();
    }

    public void insert(String key, int val) {
        mask.put(key, val);
        set.add(key);
    }

    public int sum(String prefix) {
        int sum = 0;
        for (String s : set) {
            if (s.startsWith(prefix))
                sum += mask.get(s);
        }
        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */

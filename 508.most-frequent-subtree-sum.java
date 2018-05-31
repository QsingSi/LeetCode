import java.util.Iterator;
import java.util.Map;

/*
 * [508] Most Frequent Subtree Sum
 *
 * https://leetcode.com/problems/most-frequent-subtree-sum/description/
 *
 * algorithms
 * Medium (52.30%)
 * Total Accepted:    31.6K
 * Total Submissions: 60.5K
 * Testcase Example:  '[5,2,-3]'
 *
 *
 * Given the root of a tree, you are asked to find the most frequent subtree
 * sum. The subtree sum of a node is defined as the sum of all the node values
 * formed by the subtree rooted at that node (including the node itself). So
 * what is the most frequent subtree sum value? If there is a tie, return all
 * the values with the highest frequency in any order.
 *
 *
 * Examples 1
 * Input:
 *
 * ⁠ 5
 * ⁠/  \
 * 2   -3
 *
 * return [2, -3, 4], since all the values happen only once, return all of them
 * in any order.
 *
 *
 * Examples 2
 * Input:
 *
 * ⁠ 5
 * ⁠/  \
 * 2   -5
 *
 * return [2], since 2 happens twice, however -5 only occur once.
 *
 *
 * Note:
 * You may assume the sum of values in any subtree is in the range of 32-bit
 * signed integer.
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
    private int dfs(TreeNode rt, Map<Integer, Integer>mask) {
        if (rt.left == null && rt.right == null) {
            mask.put(rt.val, mask.getOrDefault(rt.val, 0) + 1);
            return rt.val;
        }
        int left = 0, right = 0;
        if (rt.left != null) {
            left = dfs(rt.left,  mask);
        }
        if (rt.right != null) {
            right = dfs(rt.right, mask);
        }
        int tot = left + right + rt.val;
        mask.put(tot, mask.getOrDefault(tot, 0) + 1);
        return tot;
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null)
            return new int[0];
        Map<Integer, Integer> mask = new HashMap<>();
        int tmp = dfs(root, mask);
        List<Integer> cnts = new ArrayList(mask.values());
        List<Integer> sums = new ArrayList<>();
        int index = 0;
        int max = -1;
        for (Integer cnt : cnts)
            max = Math.max(max, cnt);
        Iterator iter = mask.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Integer key = (Integer) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (val == max)
                sums.add(key);
        }
        int[] res = new int[sums.size()];
        for (Integer sum : sums)
            res[index++] = sum;
        return res;
    }
}

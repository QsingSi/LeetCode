/*
 * [347] Top K Frequent Elements
 *
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 *
 * algorithms
 * Medium (49.78%)
 * Total Accepted:    106.6K
 * Total Submissions: 214.1K
 * Testcase Example:  '[1,1,1,2,2,3]\n2'
 *
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 *
 *
 * Note:
 *
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is
 * the array's size.
 *
 */
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mask = new HashMap();
        for (int num : nums)
            mask.put(num, mask.getOrDefault(num, 0) + 1);
        Iterator iter = mask.entrySet().iterator();
        int[][] cnts = new int[mask.size()][2];
        int index = 0;
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Integer cnt = (Integer) entry.getValue();
            Integer key = (Integer) entry.getKey();
            cnts[index][0] = key;
            cnts[index][1] = cnt;
            index++;
        }
        Arrays.sort(cnts, (a, b) -> b[1] - a[1]);
        List<Integer> res = new ArrayList();
        for (int i = 0; i < k; i++)
            res.add(cnts[i][0]);
        return res;
    }
}

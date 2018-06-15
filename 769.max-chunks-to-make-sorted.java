/*
 * [780] Max Chunks To Make Sorted
 *
 * https://leetcode.com/problems/max-chunks-to-make-sorted/description/
 *
 * algorithms
 * Medium (48.17%)
 * Total Accepted:    9.1K
 * Total Submissions: 18.8K
 * Testcase Example:  '[4,3,2,1,0]'
 *
 * Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], we
 * split the array into some number of "chunks" (partitions), and individually
 * sort each chunk.  After concatenating them, the result equals the sorted
 * array.
 *
 * What is the most number of chunks we could have made?
 *
 * Example 1:
 *
 *
 * Input: arr = [4,3,2,1,0]
 * Output: 1
 * Explanation:
 * Splitting into two or more chunks will not return the required result.
 * For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1,
 * 2], which isn't sorted.
 *
 *
 * Example 2:
 *
 *
 * Input: arr = [1,0,2,3,4]
 * Output: 4
 * Explanation:
 * We can split into two chunks, such as [1, 0], [2, 3, 4].
 * However, splitting into [1, 0], [2], [3], [4] is the highest number of
 * chunks possible.
 *
 *
 * Note:
 *
 *
 * arr will have length in range [1, 10].
 * arr[i] will be a permutation of [0, 1, ..., arr.length - 1].
 *
 *
 *
 */
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] bigger = new int[arr.length];
        int[] end = new int[arr.length];
        bigger[arr.length - 1] = arr.length;
        end[arr.length - 1] = arr.length;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                bigger[i] = i + 1;
                end[i] = i + 1;
            } else {
                int j = i + 2;
                for (; j < arr.length; j++)
                    if (arr[j] > arr[i])
                        break;
                bigger[i] = j;
            }
            for (int j = i + 1; j < arr.length; j++)
                if (arr[i] > arr[j])
                    end[i] = j + 1;
        }
        int cnt = 0, right = 0;
        for (int i = 0; i < arr.length;) {
            cnt++;
            for (int j = i; j < end[i]; j++)
                right = Math.max(right, end[j]);
            int tmp = right;
            for (int j = i; j < tmp; j++)
                right = Math.max(right, end[j]);
            i = right;
        }
        return cnt;
    }
}

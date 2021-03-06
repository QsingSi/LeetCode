import java.util.PriorityQueue;

/*
 * [378] Kth Smallest Element in a Sorted Matrix
 *
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 *
 * algorithms
 * Medium (45.61%)
 * Total Accepted:    61.9K
 * Total Submissions: 135.7K
 * Testcase Example:  '[[1,5,9],[10,11,13],[12,13,15]]\n8'
 *
 * Given a n x n matrix where each of the rows and columns are sorted in
 * ascending order, find the kth smallest element in the matrix.
 *
 *
 * Note that it is the kth smallest element in the sorted order, not the kth
 * distinct element.
 *
 *
 * Example:
 *
 * matrix = [
 * ⁠  [ 1,  5,  9],
 * ⁠  [10, 11, 13],
 * ⁠  [12, 13, 15]
 * ],
 * k = 8,
 *
 * return 13.
 *
 *
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> que = new PriorityQueue();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                que.add(matrix[i][j]);
            }
        }
        List<Integer> nums = new ArrayList();
        while (!que.isEmpty())
            nums.add(que.remove());
        return nums.get(k - 1);
    }
}

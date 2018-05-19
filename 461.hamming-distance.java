/*
 * [461] Hamming Distance
 *
 * https://leetcode.com/problems/hamming-distance/description/
 *
 * algorithms
 * Easy (69.52%)
 * Total Accepted:    156.2K
 * Total Submissions: 224.7K
 * Testcase Example:  '1\n4'
 *
 * The Hamming distance between two integers is the number of positions at
 * which the corresponding bits are different.
 *
 * Given two integers x and y, calculate the Hamming distance.
 *
 * Note:
 * 0 ≤ x, y < 231.
 *
 *
 * Example:
 *
 * Input: x = 1, y = 4
 *
 * Output: 2
 *
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ⁠      ↑   ↑
 *
 * The above arrows point to positions where the corresponding bits are
 * different.
 *
 *
 */
class Solution {
    public int hammingDistance(int x, int y) {
        int tmp = x ^ y;
        String bits = Integer.toBinaryString(tmp);
        int cnt = 0;
        for (char c : bits.toCharArray())
            if (c == '1')
                cnt++;
        return cnt;
    }
}

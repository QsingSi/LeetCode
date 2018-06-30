import java.util.Map;
import java.util.Queue;
/*
 * [876] Hand of Straights
 *
 * https://leetcode.com/problems/hand-of-straights/description/
 *
 * algorithms
 * Medium (42.51%)
 * Total Accepted:    4K
 * Total Submissions: 9.3K
 * Testcase Example:  '[1,2,3,6,2,3,4,7,8]\n3'
 *
 * Alice has a hand of cards, given as an array of integers.
 *
 * Now she wants to rearrange the cards into groups so that each group is size
 * W, and consists of W consecutive cards.
 *
 * Return true if and only if she can.
 *
 *
 *
 *
 *
 *
 * Example 1:
 *
 *
 * Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
 * Output: true
 * Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].
 *
 * Example 2:
 *
 *
 * Input: hand = [1,2,3,4,5], W = 4
 * Output: false
 * Explanation: Alice's hand can't be rearranged into groups of 4.
 *
 *
 *
 * Note:
 *
 *
 * 1 <= hand.length <= 10000
 * 0 <= hand[i] <= 10^9
 * 1 <= W <= hand.length
 *
 */
class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length == 0)
            return false;
        if (hand.length % W != 0)
            return false;
        Queue<Integer> q = new PriorityQueue<>();
        for (int num : hand)
            q.add(num);
        while (!q.isEmpty()) {
            int start = q.poll();
            for (int j = 1; j < W; j++) {
                if (q.remove(start + j))
                    continue;
                else return false;
            }
        }
        return true;
    }
}

import java.util.Map;

/*
 * [403] Frog Jump
 *
 * https://leetcode.com/problems/frog-jump/description/
 *
 * algorithms
 * Hard (33.35%)
 * Total Accepted:    32K
 * Total Submissions: 96K
 * Testcase Example:  '[0,1,3,4,5,7,9,10,12]'
 *
 * A frog is crossing a river. The river is divided into x units and at each
 * unit there may or may not exist a stone. The frog can jump on a stone, but
 * it must not jump into the water.
 *
 * Given a list of stones' positions (in units) in sorted ascending order,
 * determine if the frog is able to cross the river by landing on the last
 * stone. Initially, the frog is on the first stone and assume the first jump
 * must be 1 unit.
 *
 *
 * If the frog's last jump was k units, then its next jump must be either k -
 * 1, k, or k + 1 units. Note that the frog can only jump in the forward
 * direction.
 *
 * Note:
 *
 * The number of stones is ≥ 2 and is < 1,100.
 * Each stone's position will be a non-negative integer < 231.
 * The first stone's position is always 0.
 *
 *
 *
 * Example 1:
 *
 * [0,1,3,5,6,8,12,17]
 *
 * There are a total of 8 stones.
 * The first stone at the 0th unit, second stone at the 1st unit,
 * third stone at the 3rd unit, and so on...
 * The last stone at the 17th unit.
 *
 * Return true. The frog can jump to the last stone by jumping
 * 1 unit to the 2nd stone, then 2 units to the 3rd stone, then
 * 2 units to the 4th stone, then 3 units to the 6th stone,
 * 4 units to the 7th stone, and 5 units to the 8th stone.
 *
 *
 *
 * Example 2:
 *
 * [0,1,2,3,4,8,9,11]
 *
 * Return false. There is no way to jump to the last stone as
 * the gap between the 5th and 6th stone is too large.
 *
 *
 */
class Solution {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) return false;
        int n = stones.length;
        if (n == 1) return true;
        if (stones[1] != 1) return false;
        if (n == 2) return true;
        int last = stones[n - 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            if (i > 3 && stones[i] > stones[i - 1] * 2) return false;
            map.put(stones[i], i);
        }
        return dfs(stones, 0, stones[0], map, new HashMap<>());
    }

    public boolean dfs(int[] stones, int k, int pos, Map<Integer, Integer> map, Map<int[], Integer> dp) {
        if (pos == stones[stones.length - 1]) return true;
        int index = map.get(pos);
        if (pos + k + 1 < stones[index + 1]) return false;
        int[] tmp = new int[] {pos, k};
        if (dp.containsKey(tmp)) return dp.get(tmp) == 1;
        boolean mark = false;
        for (int i = k + 1; i >= k - 1; i--) {
            if (i < 1 || !map.containsKey(pos + i)) continue;
            mark |= dfs(stones, i, pos + i, map, dp);
            if (mark) break;
        }
        dp.put(tmp, mark ? 1 : 0);
        return mark;
    }
}

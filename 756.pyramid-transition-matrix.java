import java.util.List;
import java.util.Map;

/*
 * [757] Pyramid Transition Matrix
 *
 * https://leetcode.com/problems/pyramid-transition-matrix/description/
 *
 * algorithms
 * Medium (46.11%)
 * Total Accepted:    5.1K
 * Total Submissions: 11K
 * Testcase Example:  '"ABC"\n["ABD","BCE","DEF","FFF"]'
 *
 *
 * We are stacking blocks to form a pyramid.  Each block has a color which is a
 * one letter string, like `'Z'`.
 *
 * For every block of color `C` we place not in the bottom row, we are placing
 * it on top of a left block of color `A` and right block of color `B`.  We are
 * allowed to place the block there only if `(A, B, C)` is an allowed triple.
 *
 * We start with a bottom row of bottom, represented as a single string.  We
 * also start with a list of allowed triples allowed.  Each allowed triple is
 * represented as a string of length 3.
 *
 * Return true if we can build the pyramid all the way to the top, otherwise
 * false.
 *
 *
 * Example 1:
 *
 * Input: bottom = "XYZ", allowed = ["XYD", "YZE", "DEA", "FFF"]
 * Output: true
 * Explanation:
 * We can stack the pyramid like this:
 * ⁠   A
 * ⁠  / \
 * ⁠ D   E
 * ⁠/ \ / \
 * X   Y   Z
 *
 * This works because ('X', 'Y', 'D'), ('Y', 'Z', 'E'), and ('D', 'E', 'A') are
 * allowed triples.
 *
 *
 *
 * Example 2:
 *
 * Input: bottom = "XXYX", allowed = ["XXX", "XXY", "XYX", "XYY", "YXZ"]
 * Output: false
 * Explanation:
 * We can't stack the pyramid to the top.
 * Note that there could be allowed triples (A, B, C) and (A, B, D) with C !=
 * D.
 *
 *
 *
 * Note:
 *
 * bottom will be a string with length in range [2, 8].
 * allowed will have length in range [0, 200].
 * Letters in all strings will be chosen from the set {'A', 'B', 'C', 'D', 'E',
 * 'F', 'G'}.
 *
 *
 */
class Solution {
    private boolean helper(String bottom, int index, String now, List<String> allowed, Map<String, List<Character>> map) {
        if (bottom.length() == 1)
            return true;
        if (index == bottom.length() - 1)
            return helper(now, 0, "", allowed, map);
        String pre = bottom.substring(index, index + 2);
        if (map.containsKey(pre)) {
            for (Character ch : map.get(pre)) {
                if (helper(bottom, index + 1, now + ch, allowed, map))
                    return true;
            }
        }
        return false;
    }
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> mask = new HashMap<>();
        for (String s : allowed)
            mask.computeIfAbsent(s.substring(0, 2), k-> new ArrayList<>()).add(s.charAt(2));
        return helper(bottom, 0, "", allowed, mask);
    }
}

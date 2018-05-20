/*
 * [332] Reconstruct Itinerary
 *
 * https://leetcode.com/problems/reconstruct-itinerary/description/
 *
 * algorithms
 * Medium (30.03%)
 * Total Accepted:    49.2K
 * Total Submissions: 164K
 * Testcase Example:  '[["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]'
 *
 * Given a list of airline tickets represented by pairs of departure and
 * arrival airports [from, to], reconstruct the itinerary in order. All of the
 * tickets belong to a man who departs from JFK. Thus, the itinerary must begin
 * with JFK.
 *
 *
 * Note:
 *
 * If there are multiple valid itineraries, you should return the itinerary
 * that has the smallest lexical order when read as a single string. For
 * example, the itinerary ["JFK", "LGA"] has a smaller lexical order than
 * ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 *
 *
 *
 *
 * ⁠   Example 1:
 * ⁠   tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR",
 * "SFO"]]
 * ⁠   Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
 *
 *
 * ⁠   Example 2:
 * ⁠   tickets =
 * [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * ⁠   Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
 * ⁠   Another possible reconstruction is
 * ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
 *
 *
 * Credits:Special thanks to @dietpepsi for adding this problem and creating
 * all test cases.
 */
class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> targets = new HashMap<>();
        for (String[] ticket : tickets)
            targets.computeIfAbsent(ticket[0], k->new PriorityQueue()).add(ticket[1]);
        List<String> route = new LinkedList();
        List<String> st = new ArrayList();
        st.add("JFK");
        while (!st.isEmpty()) {
            while (targets.containsKey(st.get(st.size() - 1)) && !targets.get(st.get(st.size() - 1)).isEmpty())
                st.add(targets.get(st.get(st.size() - 1)).poll());
            route.add(0, st.remove(st.size() - 1));
        }
        return route;
    }
}

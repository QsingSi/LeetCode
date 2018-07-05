import java.util.ArrayList;
import java.util.Queue;


class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            Integer[] res = {0};
            return Arrays.asList(res);
        }
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (adj.get(i).size() == 1)
                res.add(i);
        while (n > 2) {
            for (int sz = res.size(); sz > 0; sz--, n--) {
                int cur = res.remove(0);
                int next = adj.get(cur).get(0);
                adj.get(next).remove(Integer.valueOf(cur));
                if (adj.get(next).size() == 1)
                    res.add(next);
            }
        }
        return res;
    }
}

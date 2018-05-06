/**
 * Definition for undirected graph. class UndirectedGraphNode { int label;
 * List<UndirectedGraphNode> neighbors; UndirectedGraphNode(int x) { label = x;
 * neighbors = new ArrayList<UndirectedGraphNode>(); } };
 */
public class Solution {
    public Map<Integer, UndirectedGraphNode> hashMap = new HashMap<Integer, UndirectedGraphNode>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;

        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        hashMap.put(node.label, clone);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            UndirectedGraphNode neighborClone = hashMap.get(neighbor.label);
            clone.neighbors.add(neighborClone == null ? cloneGraph(neighbor) : neighborClone);
        }
        return clone;
    }
}
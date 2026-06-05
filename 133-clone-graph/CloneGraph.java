/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Node createNode(Map<Integer, Node> hm, int val, List<Node> neighbors) {
        ArrayList<Node> clonedNeighbors = new ArrayList<>();
        Node clonedNode = new Node(val, clonedNeighbors);
        hm.put(val, clonedNode);
        for (Node neighbor : neighbors) {
            if (!hm.containsKey(neighbor.val)) {
                hm.put(neighbor.val, createNode(hm, neighbor.val, neighbor.neighbors));
            }
            clonedNeighbors.add(hm.get(neighbor.val));
        }
        return clonedNode;
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node head = null;
        Map<Integer, Node> hm = new HashMap<>();
        List<Node> neighbors = node.neighbors;
        return createNode(hm, node.val, neighbors);
    }
}
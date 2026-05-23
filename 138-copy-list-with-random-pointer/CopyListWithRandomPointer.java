/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> hm = new HashMap<>();
        Node currentNode = head;
        while (currentNode != null) {
            hm.put(currentNode, new Node(currentNode.val));
            currentNode = currentNode.next;
        }
        currentNode = head;
        Node clonedNode;
        while (currentNode != null) {
            clonedNode = hm.get(currentNode);
            clonedNode.next = hm.get(currentNode.next);
            clonedNode.random = hm.get(currentNode.random);
            currentNode = currentNode.next;

        }
        return hm.get(head);
    }
}
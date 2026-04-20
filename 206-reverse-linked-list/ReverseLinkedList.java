/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode prevNode, currNode, nextNode;
        prevNode = null;
        currNode = head;
        nextNode = currNode.next;
        while (nextNode != null) {
            ListNode tempNode = nextNode.next;
            currNode.next = prevNode;
            nextNode.next = currNode;
            prevNode = currNode;
            currNode = nextNode;
            nextNode = tempNode;
        }
        currNode.next = prevNode;
        head=currNode;
        return head;
    }
}
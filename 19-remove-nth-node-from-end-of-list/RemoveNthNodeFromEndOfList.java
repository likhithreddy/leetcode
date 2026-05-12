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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode resultNode, anchorNode, sentinelNode;
        sentinelNode = resultNode = anchorNode = new ListNode(0, head);
        for (int i = 0; i <= n; i++) {
            anchorNode = anchorNode.next;
        }
        while (anchorNode != null) {
            anchorNode = anchorNode.next;
            resultNode = resultNode.next;
        }
        resultNode.next = resultNode.next.next;
        return sentinelNode.next;
    }
}
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a = l1;
        ListNode b = l2;
        int carry = 0;
        ListNode head = null;
        ListNode iter = head;
        while (a != null || b != null || carry == 1) {
            int sum = carry;
            if (a != null) {
                sum += a.val;
            }
            if (b != null) {
                sum += b.val;
            }
            carry = sum / 10;
            sum %= 10;
            ListNode nextNode = new ListNode(sum);
            if (iter == null) {
                iter = nextNode;
                head = iter;
            } else {
                iter.next = nextNode;
                iter = iter.next;
            }
            if (a != null) {
                a = a.next;
            }
            if (b != null) {
                b = b.next;
            }
        }
        return head;
    }
}
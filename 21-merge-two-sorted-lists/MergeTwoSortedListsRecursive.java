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
    private void mergeRecursively(ListNode curr, ListNode list1, ListNode list2){
        if(list1 == null){
            curr.next = list2;
            return;
        }
        else if(list2 == null){
            curr.next = list1;
            return;
        }
        if(list1!=null && list2!=null){
            if (list1.val <= list2.val){
                curr.next = list1;
                mergeRecursively(curr.next,list1.next,list2);
            }
            else{
                curr.next = list2;
                mergeRecursively(curr.next,list1,list2.next);
            }
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        if(list1.val <= list2.val){
            head=list1;
            mergeRecursively(head,list1.next,list2);
        }
        else{
            head=list2;
            mergeRecursively(head,list1,list2.next);
        }
        return head;
    }
}
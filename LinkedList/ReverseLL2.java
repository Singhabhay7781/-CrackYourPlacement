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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preLeft = dummy;
        ListNode current = head;
        for(int i=1;i<=left-1;i++){
            preLeft = current;
            current = current.next;
        }
        ListNode prev = null;
        ListNode sublistHead = current;
        for(int i=0;i<=right-left;i++){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        sublistHead.next = current;
        preLeft.next = prev;
        return dummy.next;
    }
}
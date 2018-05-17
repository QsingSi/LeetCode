/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        ListNode tail = new ListNode(head.val);
        tail.next = null;
        ListNode now = head.next;
        ListNode nxt = now;
        if (now != null)
            nxt = now.next;
        while (now != null) {
            now.next = tail;
            tail = now;
            now = nxt;
            if (nxt == null)
                break;
            nxt = nxt.next;
        }
        //now.next = tail;
        return tail;
    }
}
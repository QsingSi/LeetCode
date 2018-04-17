/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = new ListNode(-1);
        ListNode result = pre;
        pre.next = head;
        while (pre.next != null && pre.next.next != null) {
            ListNode t = pre.next.next;
            pre.next.next = t.next;
            t.next = pre.next;
            pre.next = t;
            pre = t.next;
        }
        return result.next;
    }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode t = head.next;
        head.next = swapPairs(head.next.next);
        t.next = head;
        return t;
    }
}
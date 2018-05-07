/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        ListNode cur = head;
        ListNode next = null;
        ListNode pre = dummy;
        while (cur != null) {
            next = cur.next;
            while (pre.next != null && pre.next.val < cur.val)
                pre = pre.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
            pre = dummy;
        }
        return dummy.next;
    }
}
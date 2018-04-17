/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        int len = 0;
        ListNode tt = head;
        while (tt != null) {
            len++;
            tt = tt.next;
        }
        k = k % len;
        while (k-- > 0) {
            ListNode tmp = head;
            ListNode tail = new ListNode(-1);
            ListNode preTail = new ListNode(-1);
            preTail.next = tail;
            while (tmp.next != null) {
                preTail = tmp;
                tmp = tmp.next;
                tail = preTail.next;
            }
            preTail.next = null;
            tail.next = head;
            head = tail;
        }
        return head;
    }
}
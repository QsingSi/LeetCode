/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode dummy = pre;
        ListNode tmp = head;
        while (tmp != null) {
            if (tmp.val == val) {
                pre.next = tmp.next;
            } else
                pre = tmp;
            if (tmp == null)
                break;
            tmp = tmp.next;
        }
        return dummy.next;
    }
}
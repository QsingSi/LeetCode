/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode res = new ListNode(-1);
        ListNode newHead = res;
        //res.next = null;
        ListNode tmp = head;
        while (tmp != null) {
            if (tmp.val < x) {
                res.next = new ListNode(tmp.val);
                res = res.next;
            }
            tmp = tmp.next;
        }
        tmp = head;
        while (tmp != null) {
            if (tmp.val >= x) {
                res.next = new ListNode(tmp.val);
                res = res.next;
            }
            tmp = tmp.next;
        }
        return newHead.next;
    }
}
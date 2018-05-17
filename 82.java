/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode now = head;
        ListNode nxt = head.next;
        ListNode tmp = new ListNode(-1);
        tmp.next = now;
        ListNode pre = tmp;
        int cnt = 0;
        while (nxt != null) {
            while (nxt != null && now.val == nxt.val) {
                cnt++;
                nxt = nxt.next;
            }
            if (cnt == 0)
                tmp = tmp.next;
            if (cnt > 0) {
                tmp.next = nxt;
                cnt = 0;
            }
            now = nxt;
            if (nxt == null)
                break;
            //tmp = tmp.next;
            nxt = nxt.next;
        }
        return pre.next;
    }
}
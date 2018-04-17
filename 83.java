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
        int cnt = 0;
        while (nxt != null) {
            while (nxt != null && now.val == nxt.val) {
                cnt++;
                nxt = nxt.next;
            }
            if (cnt > 0) {
                now.next = nxt;
                cnt = 0;
            }
            if (nxt == null)
                break;
            now = now.next;
            nxt = nxt.next;
        }
        return head;
    }
}
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = null;
        ListNode cur = head;
        // ListNode next = cur.next;
        while (cur != null) {
            ListNode next = cur.next;
            ListNode tmp = new ListNode(cur.val);
            tmp.next = dummy.next;
            dummy.next = tmp;
            cur = next;
        }
        cur = head;
        dummy = dummy.next;
        while (cur != null) {
            if (cur.val != dummy.val)
                return false;
            cur = cur.next;
            dummy = dummy.next;
        }
        return true;
    }
}
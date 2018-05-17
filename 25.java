/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode tmp = head;
        int len = k;
        while (len > 0) {
            if (tmp == null) {
                return head;
            }
            tmp = tmp.next;
            len--;
        }
        Stack<ListNode> st = new Stack<ListNode>();
        tmp = head;
        len = k - 1;
        while (len > 0) {
            tmp = tmp.next;
            st.push(tmp);
            len--;
        }
        ListNode t = st.pop();
        tmp = t;
        head.next = reverseKGroup(t.next, k);
        while (!st.empty()) {
            tmp.next = st.pop();
            tmp = tmp.next;
        }
        tmp.next = head;
        return t;
    }
}
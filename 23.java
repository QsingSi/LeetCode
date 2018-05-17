/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode res = new ListNode(0);
        ListNode tmp = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tmp.next = new ListNode(l1.val);
                tmp = tmp.next;
                l1 = l1.next;
            } else {
                tmp.next = new ListNode(l2.val);
                tmp = tmp.next;
                l2 = l2.next;
            }
        }
        if (l1 == null)
            tmp.next = l2;
        if (l2 == null)
            tmp.next = l1;
        return res.next;
    }

    public ListNode merge(ListNode[] l, int start, int end) {
        if (start + 1 == end)
            return mergeLists(l[start], l[end]);
        if (start == end)
            return l[start];
        int mid = (start + end) / 2;
        ListNode left = merge(l, start, mid);
        ListNode right = merge(l, mid + 1, end);
        ListNode result = mergeLists(left, right);
        return result;

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        return merge(lists, 0, lists.length - 1);
    }
}
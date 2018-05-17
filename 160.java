/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode tmpA = headA, tmpB = headB;
        while (tmpA != null && tmpB != null) {
            if (tmpA == tmpB)
                return tmpA;
            tmpA = tmpA.next;
            tmpB = tmpB.next;
        }
        ListNode tmp = null;
        if (tmpA != null) {
            tmp = headA;
            while (tmpA != null) {
                tmp = tmp.next;
                tmpA = tmpA.next;
            }
            tmpA = tmp;
            tmpB = headB;
        } else if (tmpB != null) {
            tmp = headB;
            while (tmpB != null) {
                tmp = tmp.next;
                tmpB = tmpB.next;
            }
            tmpB = tmp;
            tmpA = headA;
        }
        while (tmpA != null && tmpB != null) {
            if (tmpA == tmpB)
                return tmpA;
            tmpA = tmpA.next;
            tmpB = tmpB.next;
        }
        return null;
    }
}
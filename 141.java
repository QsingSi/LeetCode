/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return false;
        ListNode firstHead = head, secondHead = head;
        ListNode firstJump = head, secondJump = head;
        while (firstJump != null && secondJump != null) {
            firstJump = firstHead.next;
            if (secondHead.next == null)
                break;
            secondJump = secondHead.next.next;
            if (firstJump == secondJump)
                return true;
            firstHead = firstJump;
            secondHead = secondJump;
        }
        return false;
    }
}
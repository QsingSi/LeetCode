/*
 * [445] Add Two Numbers II
 *
 * https://leetcode.com/problems/add-two-numbers-ii/description/
 *
 * algorithms
 * Medium (46.41%)
 * Total Accepted:    50.8K
 * Total Submissions: 109.4K
 * Testcase Example:  '[7,2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The most significant digit comes first and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 *
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the
 * lists is not allowed.
 *
 *
 *
 * Example:
 *
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 *
 *
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmp1 = l1, tmp2 = l2;
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode pre1 = dummy1, pre2 = dummy2;
        pre1.next = null;
        pre2.next = null;
        while (tmp1 != null) {
            ListNode next = tmp1.next;
            tmp1.next = pre1.next;
            pre1.next = tmp1;
            tmp1 = next;
        }
        tmp1 = dummy1.next;
        while (tmp2 != null) {
            ListNode next = tmp2.next;
            tmp2.next = pre2.next;
            pre2.next = tmp2;
            tmp2 = next;
        }
        tmp2 = dummy2.next;
        int jw = 0, ys = 0;
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        pre.next = null;
        while (tmp1 != null && tmp2 != null) {
            ys = (tmp1.val + tmp2.val + jw) % 10;
            jw = (tmp1.val + tmp2.val + jw) / 10;
            ListNode tmp = new ListNode(ys);
            tmp.next =  pre.next;
            pre.next = tmp;
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }
        while (tmp1 != null) {
            ys = (tmp1.val + jw) % 10;
            jw = (tmp1.val + jw) / 10;
            ListNode tmp = new ListNode(ys);
            tmp.next = pre.next;
            pre.next = tmp;
            tmp1 = tmp1.next;
        }
        while (tmp2 != null) {
            ys = (tmp2.val + jw) % 10;
            jw = (tmp2.val + jw) / 10;
            ListNode tmp = new ListNode(ys);
            tmp.next = pre.next;
            pre.next = tmp;
            tmp2 = tmp2.next;
        }
        if (jw != 0) {
            ListNode tmp = new ListNode(jw);
            tmp.next = pre.next;
            pre.next = tmp;
        }
        return pre.next;
    }
}

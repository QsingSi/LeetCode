/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //应该用数组，数组速度要更快
    public TreeNode build(List<Integer> nums, int start, int end) {
        if (start > end)
            return null;
        if (start == end)
            return new TreeNode(nums.get(start));
        int mid = (start + end) / 2;
        TreeNode rt = new TreeNode(nums.get(mid));
        rt.left = build(nums, start, mid - 1);
        rt.right = build(nums, mid + 1, end);
        return rt;
    }

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            nums.add(tmp.val);
            tmp = tmp.next;
        }
        return build(nums, 0, nums.size() - 1);
    }
}
import java.util.Collections;

/*
 * [315] Count of Smaller Numbers After Self
 *
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/
 *
 * algorithms
 * Hard (35.50%)
 * Total Accepted:    55.1K
 * Total Submissions: 155.1K
 * Testcase Example:  '[5,2,6,1]'
 *
 * You are given an integer array nums and you have to return a new counts
 * array. The counts array has the property where counts[i] is the number of
 * smaller elements to the right of nums[i].
 *
 * Example:
 *
 *
 * Input: [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 *
 *
 */
class Solution {

    class Node {
        int val, lessThan, count;
        Node left, right;

        public Node(int val) {
            this.val = val;
            this.lessThan = 0;
            this.count = 1;
        }
    }

    public Node add(Node root, int val, int[] ans) {
        if (root == null)
            return new Node(val);
        if (val == root.val) {
            root.count++;
            root.left = add(root.left, val, ans);
        }
        if (val < root.val) {
            root.lessThan++;
            root.left = add(root.left, val, ans);
        }
        if (val > root.val) {
            ans[0] += root.lessThan + root.count;
            root.right = add(root.right, val, ans);
        }
        return root;
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[] ans = new int[1];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[0] = 0;
            root = add(root, nums[i], ans);
            res.add(ans[0]);
        }
        Collections.reverse(res);
        return res;
    }
}

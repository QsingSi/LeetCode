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
    public int maxLevel = -1;

    public void dfs(TreeNode root, int level, int[] nums) {
        if (root == null)
            return;
        if (level > maxLevel)
            maxLevel = level;
        if (root.val > nums[level])
            nums[level] = root.val;
        dfs(root.left, level + 1, nums);
        dfs(root.right, level + 1, nums);
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        int[] nums = new int[10000];
        for (int i = 0; i < nums.length; i++)
            nums[i] = Integer.MIN_VALUE;
        dfs(root, 0, nums);
        for (int i = 0; i <= maxLevel; i++)
            res.add(nums[i]);
        return res;
    }
}
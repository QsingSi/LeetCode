/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */

public class BSTIterator {
    TreeNode root;
    TreeNode node;
    Stack<TreeNode> nodeStack = new Stack();

    public BSTIterator(TreeNode root) {
        this.root = root;
        this.node = root;
        stackNodes(root);
    }

    private void stackNodes(TreeNode root) {
        if (root == null)
            return;
        stackNodes(root.right);
        nodeStack.push(root);
        stackNodes(root.left);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !nodeStack.empty();
    }

    /** @return the next smallest number */
    public int next() {
        return nodeStack.pop().val;
    }
}

/**
 * Your BSTIterator will be called like this: BSTIterator i = new
 * BSTIterator(root); while (i.hasNext()) v[f()] = i.next();
 */
package LeetCode1;

import exam.TreeNode;

public class L104 {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) +1;
    }
}

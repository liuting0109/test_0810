package LeetCode1;

import exam.TreeNode;

public class L101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)return true;
        return Mirror(root.left,root.right);
    }
    private boolean Mirror(TreeNode t1,TreeNode t2) {
        if (t1 == null && t2 == null)return true;
        if (t1 == null || t2 == null)return false;
        if (t1.val != t2.val) return false;
        return Mirror(t1.left,t2.right) && Mirror(t1.right, t2.left);
    }
}

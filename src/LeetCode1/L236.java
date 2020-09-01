package LeetCode1;

import exam.TreeNode;

public class L236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // LCA 问题
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left !=null && right !=null)return root;// p和q在两侧
        else if (left != null) return left;
        else if (right !=null) return right;
        return null;
    }
}

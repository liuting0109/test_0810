package LeetCode1;

import exam.TreeNode;

public class L543 {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;// 访问到空节点了，返回0
        int L = depth(root.left);// 左儿子为根的子树的深度
        int R = depth(root.right);// 右儿子为根的子树的深度
        max = Math.max(max,L + R);// 计算d_node即L+R+1 并更新ans
        return Math.max(L,R) + 1;
    }
}

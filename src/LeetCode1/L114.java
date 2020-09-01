package LeetCode1;

import exam.TreeNode;

public class L114 {
    TreeNode pre = null;
    public void flatten(TreeNode root) {
        //右左根的顺序遍历
        //利用一个全局变量 pre，更新当前根节点的右指针为 pre，左指针为 null。
        if (root== null)return;
        flatten(root.right);
        flatten(root.left);
        root.right=pre;
        root.left = null;
        pre = root;
    }
}

package LeetCode;

/**
 * @Author LT
 * @Date 2020/12/27 15:41
 * @Version 1.0
 * @Description
 */
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

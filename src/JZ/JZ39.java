package JZ;

public class JZ39 {
    /*
    输入一棵二叉树，判断该二叉树是否是平衡二叉树。
   在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
     */

    /*方法2
    改为从下往上遍历，如果子树是平衡二叉树，
    则返回子树的高度；如果发现子树不是平衡二叉树，
    则直接停止遍历，这样至多只对每个结点访问一次。
     */
    public boolean IsBalanced_Solution1(TreeNode root) {
        return depth1(root) != -1;
    }

    public int depth1(TreeNode root){
        if (root == null)
            return 0;
        int left = depth1(root.left);
        if (left == -1)
            return -1;
        int right = depth1(root.right);
        if (right == -1)
            return -1;
        return Math.abs(left - right) > 1 ? -1: Math.max(left, right) + 1;
    }

    /*方法1
    遍历每个结点，借助一个获取树深度的递归函数，
    根据该结点的左右子树高度差判断是否平衡，
    然后递归地对左右子树进行判断。
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null)
            return true;
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 &&
                IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
    public int depth(TreeNode root){
        if (root == null)
            return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}

package JZ;

 /*
    输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     */

public class JZ17 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null||root2 == null)//root1的边界也要判断
            return false;
        if (root1.val == root2.val){
            if (help(root1, root2))
                return true;
        }
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private boolean help(TreeNode root1, TreeNode root2) {//判断是否是子结构
        if (root2 == null)//子结构已经循环完毕，代表全部匹配
            return true;
        if (root1 == null)//大树已经循环完毕，并未成功匹配
            return false;
        if (root1.val == root2.val){//相等后判断左右孩子
            return help(root1.left, root2.left) && help(root1.right, root2.right);
        }
        return false;
    }
}

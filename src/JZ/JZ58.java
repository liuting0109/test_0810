package JZ;
/*请实现一个函数，用来判断一棵二叉树是不是对称的。
注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class JZ58 {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null)
            return true;
        return judge(pRoot.left, pRoot.right);
    }

    private boolean judge(TreeNode node1, TreeNode node2) {
        if (node1 == null)
            return node2 == null? true: false;

        if (node2 == null)
            return false;

        /*if (node1 == null && node2 == null)
            return true;
        if (node1 == null || node2 == null)
            return false;*/

        if (node1.val != node2.val){
            return false;
        }else {
            return judge(node1.left, node2.right) && judge(node2.left, node1.right);
        }
    }

}

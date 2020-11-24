package JZ;

import java.util.LinkedList;
import java.util.Queue;


/*请实现一个函数，用来判断一棵二叉树是不是对称的。
注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class JZ58 {
    //方法1：递归
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

    //方法2：栈
    /*
    * DFS使用stack来保存成对的节点
        *1.出栈的时候也是成对成对的 ，
        1.若都为空，继续；
        2.一个为空，返回false;
        3.不为空，比较当前值，值不等，返回false；
        * 2.确定入栈顺序，每次入栈都是成对成对的，如left.left， right.right ;left.rigth,right.left
     */
   /* boolean isSymmetrical1(TreeNode pRoot){
        if (pRoot == null) return true;
        Stack<TreeNode> s = new Stack<>();

    }*/
    /*
    * BFS使用Queue来保存成对的节点，代码和上面极其相似
    * 1.出队的时候也是成对成对的
    1.若都为空，继续；
    2.一个为空，返回false;
    3.不为空，比较当前值，值不等，返回false；
    * 2.确定入队顺序，每次入队都是成对成对的，如left.left， right.right ;left.rigth,right.left
    */
    boolean isSymmetrical2(TreeNode pRoot){
        if(pRoot == null) return true;
        Queue<TreeNode> s = new LinkedList<>();
        s.offer(pRoot.left);
        s.offer(pRoot.right);
        while (!s.isEmpty()){
            TreeNode left = s.poll();//成对取出
            TreeNode right = s.poll();
            if (left == null && right == null)
                continue;//return true;错误
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;
            //成对取出
            s.offer(left.left);
            s.offer(right.right);
            s.offer(left.right);
            s.offer(right.left);
        }
        return true;
    }

}

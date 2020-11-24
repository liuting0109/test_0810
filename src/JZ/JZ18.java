package JZ;

import java.util.*;

public class JZ18 {
    //操作给定的二叉树，将其变换为源二叉树的镜像。
    //递归
    public void Mirror(TreeNode root) {
        if (root == null)
            return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }

    //非递归,用队列
    public void Mirror1(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> nodes = new LinkedList<>();
        TreeNode cur, tmp;
        nodes.offer(root);//添加一个元素并返回true  ； peek查询队首元素
        while (!nodes.isEmpty()){
            int len = nodes.size();
            for (int i = 0; i < len; i++) {
                cur = nodes.poll();//移除并返问队列头部的元素
                tmp = cur.left;
                cur.left = cur.right;
                cur.right = tmp;
                if (cur.left != null) nodes.offer(cur.left);
                if (cur.right != null) nodes.offer(cur.right);
            }
        }
    }

    //非递归,用栈
    public void Mirror3(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            //if (node.left != null ||node.right != null){//好像不用判断
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            //}
            if (node.left != null){
                stack.push(node.left);
            }
            if (node.right != null){
                stack.push(node.right);
            }
        }
    }
}

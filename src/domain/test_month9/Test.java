package domain.test_month9;


import java.util.Scanner;
import java.util.Stack;

class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int val){
        this.val = val;
    }
}

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
    }
    //二叉树前序遍历 根左右
    public static void preOrder(TreeNode root){
        if (root != null){
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public static void preOrder1(TreeNode root){//非递归
        if (root == null) {
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        TreeNode curNode;
        while (!s.isEmpty()) {
            curNode = s.pop();
            System.out.print(curNode.val + " ");
            // 栈先进后出，所以先加入右侧节点，这样输出的时候，先输出左侧节点
            if (curNode.right != null) {
                s.push(curNode.right);
            }
            if (curNode.left != null) {
                s.push(curNode.left);
            }
        }

    }

    //二叉树中序遍历 左根右
    public static void inOrder(TreeNode root){
        if (root != null){
            inOrder(root.left);
            System.out.println(root.val);
            inOrder(root.right);
        }
    }
    public static void inOrder1(TreeNode root){//非递归
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            // 入栈所有左节点并输出左节点
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()){
                // 弹出左节点
                root = stack.pop();//叶子节点的父节点
                System.out.println(root.val);
                // 弹出后，指向当前节点的右节点
                root = root.right;//父节点的右节点，可能为null
            }
        }
    }

    //二叉树后序遍历 左右根 ???
    public static void postOrder(TreeNode root){
        if (root == null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.val);
        }
    }
    //二叉树后序遍历正解
    //https://blog.csdn.net/qq_39445165/article/details/90749343
    public static void postOrder2(TreeNode root){
        Stack<TreeNode> src = new Stack<TreeNode>();
        Stack<TreeNode> res = new Stack<TreeNode>();
        src.push(root);
        while (!src.isEmpty()){
            TreeNode p = src.pop();
            res.push(p);
            if(p.left != null){
                src.push(p.left);
            }
            if(p.right != null){
                src.push(p.right);
            }
        }
        while (!res.isEmpty()){
            System.out.println(res.pop().val +" ");
        }
    }
    public static void postOrder1(TreeNode root){//非递归
        Stack<TreeNode> s1= new Stack<>();
        Stack<TreeNode> s2= new Stack<>();
        s1.push(root);
        TreeNode curNode;
        while (!s1.isEmpty()){
            curNode = s1.pop();
            // 中、右、左顺序压入栈中
            s2.push(curNode);
            // 压入s1为先左后右，保证中、右、左顺序压入s2
            if (curNode.left != null){
                s1.push(curNode.left);
            }
            if (curNode.right != null){
                s1.push(curNode.right);
            }
        }
        while (!s2.isEmpty()){
            System.out.println(s2.pop());
        }
    }
    /*非递归实现

    后续遍历的非递归实现是这三种方式中最难实现的一种，因为根节点是最后才被访问的，
    所以需要对之前的节点进行记忆。
    即将上一次访问过的节点记录下来，当遇到没有左、右子节点的叶子节点时，
    先判断当前叶子节点的父节点的右子节点是否被访问过，如果没有被访问过，
    则继续遍历右节点（这个右节点是叶子节点的兄弟节点）；如果被访问过，则打印当前的叶子节点。

     */
    public void afterOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode lastVisit = root;//记录上一次遍历过的节点
        while (!stack.empty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.peek();
            if (node.right == null||node.right == lastVisit){
                System.out.println(node.val);
                stack.pop();
                lastVisit = node;
                node=null;
            }else{
                node = node.right;
            }
        }
    }

}

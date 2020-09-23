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
    //二叉树前序遍历
    public static void preOrder(TreeNode root){
        System.out.println(root);
        if (root.left != null){
            preOrder(root.left);
        }
        if (root.right != null){
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

    //二叉树中序遍历
    public static void inOrder(TreeNode root){
        if (root == null)
            return;

        if (root.left != null){
            preOrder(root.left);
        }
        System.out.println(root);
        if (root.right != null){
            preOrder(root.right);
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
                root = stack.pop();
                System.out.println(root);
                // 弹出后，指向当前节点的右节点
                root = root.right;
            }
        }
    }

    //二叉树后序遍历
    public static void postOrder(TreeNode root){
        if (root == null)
            return;
        if (root.left != null){
            preOrder(root.left);
        }

        if (root.right != null){
            preOrder(root.right);
        }
        System.out.println(root);
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

}

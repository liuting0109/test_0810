package LeetCode1;

import exam.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L94 {
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {

        /*helper(root);//递归
        return res;
        */

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            if (root !=null){
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }

    private void helper(TreeNode root) {//递归
        if (root!=null) {
            if (root.left != null)
                helper(root.left);
            res.add(root.val);
            if (root.right != null)
                helper(root.right);
        }
    }
}

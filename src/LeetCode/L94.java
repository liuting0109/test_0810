package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author LT
 * @Date 2020/12/27 15:17
 * @Version 1.0
 * @Description
 */
public class L94 {
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            if (root != null){
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

    //递归
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return res;
        if (root.left != null) inorderTraversal(root.left);
        res.add(root.val);
        if (root.right != null) inorderTraversal(root.right);
        return res;
    }
}

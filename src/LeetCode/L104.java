package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author LT
 * @Date 2020/12/26 17:49
 * @Version 1.0
 * @Description
 */
//二叉树深度
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){};
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class L104 {
    //递归
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    //非递归
    public int maxDepth1(TreeNode root) {
        int depth  = 0;
        //Queue<TreeNode> queue = new ArrayList<TreeNode>();//报错，啊呸
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        int newCount = 1;
        if (root == null) return 0;
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            count ++;
            if (temp.left != null){
                queue.offer(temp.left);
            }
            if (temp.right != null){
                queue.offer(temp.right);
            }
            if (count == newCount){
                newCount = queue.size();
                count = 0;
                depth ++;
            }
        }
        return depth;
    }
}

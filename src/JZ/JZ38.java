package JZ;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  输入一棵二叉树，求该树的深度。
 *  从根结点到叶结点依次经过的结点（含根、叶结点）
 *  形成树的一条路径，最长路径的长度为树的深度。
 */
public class JZ38 {
    /*非递归:队列层次遍历
    depth：当前节点所在的层数，count已经遍历了的节点数，
    nextCount下层的节点总数；
    当count==nextCount的时候，代表本层的节点已经遍历完毕。
    */
    public int TreeDepth1(TreeNode root) {
        if (root == null)
            return 0;
        int depth = 0, count = 0, nextcount = 1; //nextcount = 1
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            count ++;

            if (temp.left != null){
                queue.offer(temp.left);
            }
            if (temp.right != null){
                queue.offer(temp.right);
            }
            if (count == nextcount){
                nextcount = queue.size();
                count = 0;
                depth++;
            }
        }
        return depth;
    }

    //递归
    public int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }
}

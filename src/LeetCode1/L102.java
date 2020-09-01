package LeetCode1;

import exam.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int count = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            while(count > 0){//Queue 中 remove() 和 poll()都是用来从队列头部删除一个元素。
                //在队列元素为空的情况下，remove() 方法会抛出NoSuchElementException异常，poll() 方法只会返回 null 。
               TreeNode node = queue.poll();
               list.add(node.val);
               if (node.left != null)queue.add(node.left);
               if (node.right !=null)queue.add(node.right);
               count --;
            }
            res.add(list);
        }
        return res;
    }
}

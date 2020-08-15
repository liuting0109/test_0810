package JZ;

import java.util.*;

//从上往下打印出二叉树的每个节点，同层节点从左至右打印。
public class JZ22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);//offer（添加队尾元素）
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();//peek（访问队头元素）、poll（访问队头元素并移除）
            res.add(temp.val);
            if (temp.left != null){
                queue.add(temp.left);//写错了！！queue.add(root.left);
                //两者都是往队列尾部插入元素
                // 当超出队列界限的时候，add（）方法是抛出异常让你处理，而offer（）方法是直接返回false
            }
            if (temp.right != null){
                queue.add(temp.right);
            }
        }
        return res;
    }
}

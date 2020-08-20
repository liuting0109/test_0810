package JZ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
请实现一个函数按照之字形打印二叉树，
即第一行按照从左到右的顺序打印，
第二层按照从右至左的顺序打印，
第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class JZ59 {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        int sum = 1;
        int num = 1;
        while (!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int temp = 0;
            while (sum > 0){
                TreeNode node = queue.poll();
                list.add(node.val);
                sum --;

                if (node.left != null){
                    queue.add(node.left);
                    temp++;
                }
                if (node.right != null){
                    queue.add(node.right);
                    temp++;
                }
            }
            sum = temp;

            if (num % 2 == 0){
                for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
                    int t = list.get(i);
                    //list.get(i) = list.get(j);
                    list.set(i , list.get(j));
                    list.set(j, t);
                }
            }
            num++;
            res.add(list);

        }
        return res;
    }
}

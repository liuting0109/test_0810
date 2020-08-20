package JZ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class JZ60 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        JZ60 jz60 = new JZ60();
        TreeNode treeNode = jz60.createBinaryTreeByArray(array, 0);
        for (ArrayList list :
                jz60.Print(treeNode)) {
            System.out.println(list);
        }
    }

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        int sum = 1;//初始层数为1
        //int count = 0;//保存每一层的节点个数

        while (!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int temp = 0;
            while (sum > 0){
                TreeNode node = queue.poll();
                list.add(node.val);
                sum --;

                //每打印一个节点，就把此节点的下一层的左右节点加入队列，并记录下一层要打印的个数
                if (node.left != null){
                    temp++;
                    queue.offer(node.left);
                }
                if (node.right != null){
                    temp++;
                    queue.offer(node.right);
                }
            }
            sum = temp;
            res.add(list);
        }
        return res;
    }


    private TreeNode createBinaryTreeByArray(int[] array, int index) {
        TreeNode tn = null;
        if (index < array.length) {
            int value = array[index];
            tn = new TreeNode(value);
            tn.left = createBinaryTreeByArray(array, 2 * index + 1);
            tn.right = createBinaryTreeByArray(array, 2 * index + 2);
            return tn;
        }
        return tn;
    }
}

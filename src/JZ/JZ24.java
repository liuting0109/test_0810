package JZ;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，
 * 按字典序打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class JZ24 {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null)return res;
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left ==null && root.right ==null){
            //res.add(list);//要创建对象!!!!
            //不重新new的话从始至终res中所有引用都指向了同一个一个list，
            // 也就是输出结果都是一样的[][][]或者[1,1],[1,1],[1,1]
            res.add(new ArrayList<>(list));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size() - 1);//!!!!!!!!回溯恢复路径
        //移除最后一个元素啊，深度遍历完一条路径后要回退
        return res;
    }


}

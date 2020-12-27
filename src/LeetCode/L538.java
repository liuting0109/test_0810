package LeetCode;



public class L538 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        //BST的中序遍历就是从小到大,那么反过来就是从大到小,然后累加就好了.
        // 以右->根->左的顺序遍历二叉树，将遍历顺序的前一个结点的累加值记录起来，和当前结点相加，得到当前结点的累加值。
        if (root != null){
            convertBST(root.right);//右
            sum += root.val;
            root.val = sum;//根
            convertBST(root.left);//左
        }
        return root;
    }
}

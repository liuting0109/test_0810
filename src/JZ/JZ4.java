package JZ;

import java.util.Arrays;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
}

public class JZ4 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] res = Arrays.copyOfRange(arr1, 0, 2);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0 || in.length == 0)//递归结束条件，不可少
            return null;
        //int root = pre[0];
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (in[i]  == root.val){//if (in[i] == root.val)
                root.left = reConstructBinaryTree
                        (Arrays.copyOfRange(pre, 1 ,i + 1),Arrays.copyOfRange(in, 0 ,i));
                root.right = reConstructBinaryTree
                        (Arrays.copyOfRange(pre, i + 1,pre.length),Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        return root;
    }


}



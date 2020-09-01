package LeetCode1;

import exam.TreeNode;

import java.util.Arrays;

public class L105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]){//Arrays.copyOfRange左边取得到，右边取不到
                root.left = buildTree(Arrays.copyOfRange(preorder,1,i + 1),
                        Arrays.copyOfRange(inorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(preorder,i +1,preorder.length),
                        Arrays.copyOfRange(inorder, i+ 1, inorder.length));
            }
        }
        return root;
    }
}

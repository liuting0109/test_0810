package LeetCode1;

import exam.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class L98 {
    long pre = Long.MIN_VALUE;//int。minvalue不行，范围不够

    List<Integer> res = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        /**
         * 中序遍历时，判断当前节点是否大于中序遍历的前一个节点，
         * 如果大于，说明满足 BST，继续遍历；否则直接返回 false。
         */
        if (root == null)
            return true;
        if (!isValidBST(root.left)){// 访问左子树
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，
        // 说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre)
            return false;

        pre = root.val;
        return isValidBST(root.right);// 访问右子树

        //方法2：二叉搜索树中序遍历得到升序
        // ，结果记录于res之中，检验res是否为严格的升序，若是则为true
       /* if (root==null)return true;
        inOrder(root);
        for (int i = 0; i < res.size() - 1; i++) {
            if (res.get(i) >= res.get(i + 1)){
                return false;
            }
        }
        return true;*/
    }

    private void inOrder(TreeNode root) {
        if (root != null){
            inOrder(root.left);
            res.add(root.val);
            inOrder(root.right);
        }
    }
}

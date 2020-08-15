package JZ;

import java.util.ArrayList;

/*
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class JZ26 {
    ArrayList<TreeNode> list = new ArrayList<>();

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        inOrder(pRootOfTree);
        return Convert(list);
    }

    //中序遍历，在list中按遍历顺序保存
    public void inOrder(TreeNode root) {
        if (root.left != null)
            inOrder(root.left);
        list.add(root);
        if (root.right != null)
            inOrder(root.right);
    }

    //遍历list，修改指针
    public TreeNode Convert(ArrayList<TreeNode> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).right = list.get(i + 1);
            list.get(i + 1).left = list.get(i);
        }
        return list.get(0);
    }

    //直接用中序遍历????????????????
    public class Solution {
        TreeNode head = null;
        TreeNode realHead = null;

        public TreeNode Convert(TreeNode pRootOfTree) {
            ConvertSub(pRootOfTree);
            return realHead;
        }

        private void ConvertSub(TreeNode pRootOfTree) {
            if (pRootOfTree == null) return;
            ConvertSub(pRootOfTree.left);
            if (head == null) {
                head = pRootOfTree;
                realHead = pRootOfTree;
            } else {
                head.right = pRootOfTree;
                pRootOfTree.left = head;
                head = pRootOfTree;
            }
            ConvertSub(pRootOfTree.right);
        }
    }
}

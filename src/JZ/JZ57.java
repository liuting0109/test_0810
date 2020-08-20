package JZ;

import java.util.ArrayList;

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
/*
给定一个二叉树和其中的一个结点，请
找出中序遍历顺序的下一个结点并且返回。
注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class JZ57 {
    ArrayList<TreeLinkNode> list = new ArrayList<>();
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        TreeLinkNode par = pNode;
        while (par.next != null){//找到父节点
            par = par.next;
        }

        inOrder(par);
        for (int i = 0; i < list.size(); i++) {
            if (pNode == list.get(i))
                return i == list.size() - 1 ? null : list.get(i + 1);
        }
        return null;
    }

    public void inOrder(TreeLinkNode pNode){
        if (pNode == null)return;

        if (pNode.left != null)
            inOrder(pNode.left);
        list.add(pNode);
        if (pNode.right != null)
            inOrder(pNode.right);
        /*亦可 不用判断左右子树是否存在 因为递归时也会进行判断
        if (pNode == null)return;
        inOrder(pNode.left);
        list.add(pNode);
        inOrder(pNode.right);
         */
    }
}

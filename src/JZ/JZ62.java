package JZ;

public class JZ62 {
    //给定一棵二叉搜索树，请找出其中的第k小的结点。
    // 例如， （5，3，7，2，4，6，8）中，
    // 按结点数值大小顺序第三小结点的值为4。
    int index;
    TreeNode ans;
    TreeNode KthNode(TreeNode pRoot, int k)
    {   index =1;
        ans = null;
        if (k != 0 && pRoot != null)
            KkthNode(pRoot, k);
        return ans;
    }
    //二叉搜索树（左节点全小于根节点，右节点全大于根节点）
    //中序遍历后是单调递增的序列，
    public void  KkthNode(TreeNode pRoot, int k){
        if (pRoot.left!= null){
            KkthNode(pRoot.left,k);
        }
        if (index == k) {
            ans = pRoot;
           // return;//此处加return不对
        }
        index++;
        if (pRoot.right!= null){
            KkthNode(pRoot.right,k);
        }
    }
}

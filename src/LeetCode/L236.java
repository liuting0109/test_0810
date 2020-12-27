package LeetCode;

/**
 * @Author LT
 * @Date 2020/12/27 16:11
 * @Version 1.0
 * @Description
 */
public class L236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // LCA 问题
        //所有的递归的返回值有4种可能性，null、p、q、公共祖先
        //当遍历到叶结点后就会返回null
        /*
        //当遍历到叶结点后就会返回null
        当然，值得一提的是，如果公共祖先是自己（pq），并不需要寻找另外
         一个，我们在执行前序遍历会先找上面的，后找下面的，我们会直接返回公共祖先
         */
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);//返回的结点进行保存，可能是null
        TreeNode right = lowestCommonAncestor(root.right, p, q);//也可能是pq，还可能是公共祖先
        if (left !=null && right !=null)
            return root;// p和q在两侧,//如果左右都存在，就说明pq都出现了，
            // 这就是，公共祖先，此时不用考虑公共祖先是自己的情况，因为上面已经做过判断了。
        else if (left != null)//否则我们返回已经找到的那个值（存储在left，与right中），p或者q
            return left;
        else if (right !=null)//还有一种可能就是，由下面返回的公共祖先，并将这个值一路返回到最表层
            return right;

        return null;
    }
}

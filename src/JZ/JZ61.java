package JZ;

public class JZ61 {
    //序列化和反序列化二叉树
    String Serialize(TreeNode root) {
        if (root == null)
            return "";
        return helpSerialize(root, new StringBuilder()).toString();
    }

    private StringBuilder helpSerialize(TreeNode root, StringBuilder sb) {
        //采用的是前序遍历，中左右）
        sb.append(root.val).append("!");
        if (root.left != null){//遇到null的时候添加#!号，遇到数值添加!即可
            helpSerialize(root.left, sb);
        }else
            sb.append("#!");// 为null的话直接添加即可

        if (root.right != null){
            helpSerialize(root.right, sb);
        }else
            sb.append("#!");
        return sb;
    }

    int k = 0;// 设置全局主要是遇到了#号的时候需要直接前进并返回null
    TreeNode Deserialize(String str) {
        if (str.length() == 0 || str == null)
            return null;
        String[] split = str.split("!");
        return helpDeSerialize(split);
    }

    private TreeNode helpDeSerialize(String[] split) {
        if (split[k].equals("#")){
            k++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(split[k]));
        k++;
        root.left = helpDeSerialize(split);
        root.right = helpDeSerialize(split);
        return root;
    }
}

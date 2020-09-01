package LeetCode1;

import exam.TreeNode;

public class L437 {
    int pathNum;
    public int pathSum(TreeNode root, int sum) {
        // 双重递归 思路：首先先序递归遍历每个节点，再以每个节点作为起始点递归寻找满足条件的路径。
        if (root == null)return 0;
        Sum(root,sum);
        pathSum(root.left,sum);
        pathSum(root.right,sum);
        return pathNum;
    }

    private void Sum(TreeNode root, int sum) {
        if (root == null)return;
        sum -= root.val;
        if (sum == 0){
            pathNum++;
        }
        Sum(root.left,sum);
        Sum(root.right,sum);
    }
}

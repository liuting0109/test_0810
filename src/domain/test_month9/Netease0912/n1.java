package domain.test_month9.Netease0912;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/12 15:33
 * @Version 1.0
 * @Description
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
}
public class n1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        String[][] str = new String[n][3];
        //TreeNode root = new TreeNode(1);
        //root.left = new TreeNode(-1);
        /*for (int i = 0; i < n; i++) {
            //String s = new String(i+" ");
            TreeNode A = new TreeNode(i + 1);
        }*/
        List<TreeNode> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(new TreeNode(i + 1));
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                str[i][j] = sc.next();
            }
            int root = Integer.valueOf(str[i][0]);
            int yezi = Integer.valueOf(str[i][1]);
            for(TreeNode tn: list){
                if (tn.val == root){
                    if (str[i][1].equals("left")){

                        tn.left = new TreeNode(Integer.valueOf(str[i][2]));
                    }else if (str[i][1].equals("right")){
                        tn.right = new TreeNode(Integer.valueOf(str[i][2]));
                    }
                }
            }
        }
        System.out.println(2);

    }
}

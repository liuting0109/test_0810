package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author LT
 * @Date 2020/12/27 15:01
 * @Version 1.0
 * @Description
 */
public class L22 {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        // 特判
        if (n == 0) {
            return res;
        }
        dfs(n, n ,"");
        return res;
    }

    //深度优先遍历
    private void dfs(int left, int right, String curStr) {
        if (left == 0 && right == 0){//左右括号都不剩余了，递归终止
            res.add(curStr);
            return;
        }

        if (left > 0){// 如果左括号还剩余的话，可以拼接左括号
            dfs(left - 1, right, curStr +"(");
        }
        if (right > left){// 如果右括号剩余多于左括号剩余的话，可以拼接右括号
            dfs(left, right -1, curStr +")");
        }

    }
}

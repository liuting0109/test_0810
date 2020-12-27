package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author LT
 * @Date 2020/9/24 21:59
 * @Version 1.0
 * @Description
 */
public class L40 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        temp = new ArrayList<>();
        Arrays.sort(candidates);//为了去重
        dfs(candidates, target, 0 ,0);
        return res;
    }

    private void dfs(int[] candidates, int target, int curSum, int curIndex) {
        if (curSum == target){
            res.add(new ArrayList<>(temp));
            return;
        }else if (curSum > target){
            return;
        }
        for (int i = curIndex; i < candidates.length; i++) {
            if (i > curIndex && candidates[i] == candidates[i - 1]){//去重
                continue;
            }
            temp.add(candidates[i]);
            dfs(candidates, target, curSum + candidates[i], i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}

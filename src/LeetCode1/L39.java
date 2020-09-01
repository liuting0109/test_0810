package LeetCode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(res, list, candidates,target,0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target, int num) {
        if (target == 0){//递归的终点
            res.add(temp);
            return;
        }
        if (target < candidates[num])return;
        for (int i = num; i < candidates.length && candidates[i] <= target; i++) {
            List<Integer> list = new ArrayList<>(temp);//拷贝一份，不影响下次递归
            list.add(candidates[i]);
            //递归运算，将i传递至下一次运算是为了避免结果重复。
            dfs(res, list, candidates, target-candidates[i],i);
        }
    }
}

package JZ;

import java.util.ArrayList;
/*
输出所有和为S的连续正数序列。
序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class JZ41 {
    //ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindContinuousSequence1(int sum) {
        int start = 1;
        int end = 2;
        int curSum = 3;
        while (end < sum){//start <= sum错误！！！
            if (curSum < sum){
                end++;
                curSum += end;//注意执行顺序
            }else if (curSum == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    list.add(i);
                }
                res.add(list);
                curSum -= start;
                start++;
                end++;
                curSum +=end;
            }else if (curSum > sum){
                curSum -= start;
                start++;
            }

        }
        return res;
    }
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        int start = 1;
        int end = 2;
        int curSum = 3;
        while (end < sum){
            if (curSum < sum){
                end++;
                curSum += end;
            }else if (curSum > sum){
                curSum -= start;
                start++;
            }else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    list.add(i);
                }
                res.add(list);

                curSum -= start;//找到一组数后 还要继续将数组往后挪
                start++;
                end++;
                curSum += end;
            }
        }
        return res;
    }
}

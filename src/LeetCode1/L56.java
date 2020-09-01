package LeetCode1;

import java.util.Arrays;

public class L56 {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = merge1(intervals);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j]);
            }
            System.out.println();
        }
        System.out.println(res);
    }
    public static int[][] merge1(int[][] intervals) {
        Arrays.sort(intervals,(o1, o2)-> o1[0] - o2[0]);
        int[][] res = new int[intervals.length][2];
        int index = 0;
        //for (int i = 0; i < intervals.length; i++) {//错误 没有i++
        for (int i = 0; i < intervals.length; ){
            int t = intervals[i][1];
            int j = i + 1;
            while (j < intervals.length && intervals[j][0] <= t){
                t = Math.max(t, intervals[j][1]);
                j++;
            }
            res[index][0] =intervals[i][0];
            res[index][1] = t;
            index++;
            i = j;
        }
        //return res;//不对
        return Arrays.copyOf(res,index);
    }
    public int[][] merge(int[][] intervals) {
        /*Lambda 表达式的简单例子:
         * // 1. 不需要参数,返回值为 5
         * () -> 5
         * // 2. 接收一个参数(数字类型),返回其2倍的值
         * x -> 2 * x
         * // 3. 接受2个参数(数字),并返回他们的差值
         * (x, y) -> x – y
         * // 4. 接收2个int型整数,返回他们的和
         * (int x, int y) -> x + y
         * // 5. 接受一个 string 对象,并在控制台打印,不返回任何值(看起来像是返回void)
         * (String s) -> System.out.print(s)
         */
        Arrays.sort(intervals, (o1, o2)-> o1[0] - o2[0]);//返回差值
        int[][] res = new int[intervals.length][2];
        int index = -1;
        for (int[] i:intervals){
            // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
            // 则不合并，直接将当前区间加入结果数组。
            if (index == -1 || i[0] > res[index][1])
                res[++index] = i;
            else { // 反之将当前区间合并至结果数组的最后区间
                res[index][1] = Math.max(res[index][1],i[1]);
            }
        }
        return Arrays.copyOf(res,index+ 1);
    }
}

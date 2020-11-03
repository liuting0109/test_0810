package domain.test_month10.XieCheng;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/10/13 9:56
 * @Version 1.0
 * @Description
 */
/*
正值下班高峰时期，现有可载客司机数2N人，调度中心将调度相关司机服务A、B两个出行高峰区域。
第 i 个司机前往服务A区域可得收入为 income[i][0]，前往服务B区域可得收入为 income[i][1]。
返回将每位司机调度完成服务后，所有司机总可得的最高收入金额，要求每个区域都有 N 位司机服务。
输入描述
10 20
20 40
#
如上：
第一个司机服务 A 区域，收入为 10元
第一个司机服务 B 区域，收入为 20元
第二个司机服务 A 区域，收入为 20元
第二个司机服务 B 区域，收入为 40元
输入参数以 '#' 结束输入
输出描述
最高总收入为 10 + 40= 50，每个区域都有一半司机服务
参数及相关数据异常请输出：error

样例输入
10 30
100 200
150 50
60 20
#
样例输出
440
提示
最优策略
1 <= income.length <= 100
income.length 为偶数
1 <= income[i][0], income[i][1] <= 1000
 */

    /*
    10 30
100 200
150 50
60 20
#
     */
public class X2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while (cin.hasNextInt()) {
            int incomeOfA = cin.nextInt();
            int incomeOfB = cin.nextInt();
            //System.out.println(incomeOfA);
            //System.out.println(incomeOfB);
            list.add(incomeOfA);
            list.add(incomeOfB);

            //Start coding -- Input Data
        }
        if (list.size() /2 %2 != 0){
            System.out.println("error");
            System.exit(0);
        }

        int index = 0;
        int[] A = new int[list.size() / 2];
        int[] B = new int[list.size() / 2];
        for (int i = 0; i < list.size()/2; i++) {
            A[i] = list.get(index++);
            B[i] = list.get(index++);
        }

        for (int i = 0; i < A.length; i++) {
            //System.out.println(A[i]);
            //System.out.println(B[i]);
        }
        //Start coding

    }
}

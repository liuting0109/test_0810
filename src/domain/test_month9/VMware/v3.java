package domain.test_month9.VMware;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/21 21:13
 * @Version 1.0
 * @Description
 */
/*
在做物理实验匀速运动问题的途中，小A遇到了如下计算上的困难，他决定让计算机来帮忙解决这一问题。

这个问题描述如下，小球在一个大小为n的正方形中绕着边界逆时针匀速走动。

假设球一开始坐标在（0,0）,正方形的四个角分别为(0,0),(n,0),(n,n),(0,n)。

现在，小球每走r个单位距离，就要记录下小球所在的坐标，一共需要记录m次。给出n,m,r,请你计算小球的位置。



输入描述
输入包含三个数，n,m,r,中间以空格隔开，其中n,r可能为小数

1≤n,r≤2×107，m≤100

输出描述
输出m行，每行两个小数空格隔开，保留2位（四舍五入），代表每一次记录的坐标。


样例输入
3 5 5
样例输出
3.00 2.00
0.00 2.00
3.00 0.00
1.00 3.00
1.00 0.00

提示
样例输入2
7495417.6435616808 10 6125201.7312234128

样例输出2
6125201.73 0.00
7495417.64 4754985.82
4110647.74 7495417.64
0.00 5480863.65
644338.08 0.00
6769539.81 0.00
7495417.64 5399323.90
3466309.66 7495417.64
0.00 4836525.57
1288676.16 0.00
 */
public class v3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        int m = sc.nextInt();
        double r = sc.nextDouble();
        //System.out.println(5 % 12);
        fun(n, r , m);
    }

    private static void fun(double n, double r, int m) {


        DecimalFormat df = new DecimalFormat("0.00");
        for (int i = 1; i <= m; i++) {
            double distance = (r * i) % (4.00 *n);
            //System.out.println(distance);
            if (distance <= n){
                System.out.println(df.format(distance) + " " + df.format(0));
            }else if (distance <= 2*n){
                System.out.println(df.format(n) + " "+ df.format(distance - n));
            }else if (distance <= 3 *n){
                System.out.println(df.format(3 * n - distance) + " " + df.format(n));
            }else {
                System.out.println(df.format(0) + " "+ df.format( 4 * n -distance));
            }
        }

    }


}

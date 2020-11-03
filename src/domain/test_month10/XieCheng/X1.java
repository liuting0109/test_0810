package domain.test_month10.XieCheng;

import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/10/13 9:56
 * @Version 1.0
 * @Description
 */
/*
贩卖机只支持硬币支付，且收退都只支持10 ，50，100 三种面额。一次购买行为只能出一瓶可乐，且每次购买后总是找零最小枚数的硬币。（例如投入100圆，可乐30圆，则找零50圆一枚，10圆两枚）
游游需要购买的可乐数量是 m，其中手头拥有的 10,50,100 面额硬币的枚数分别是 a,b,c，可乐的价格是x(x是10的倍数)。
如果游游优先使用大面额购买且钱是够的情况下,请计算出需要投入硬币次数？
输入描述
依次输入，
需要可乐的数量为 m
10元的张数为 a
50元的张数为 b
100元的张树为 c
1瓶可乐的价格为 x

输出描述
输出当前金额下需要投入硬币的次数
例如需要购买2瓶可乐，每瓶可乐250圆，手里有100圆3枚，50圆4枚，10圆1枚。
购买第1瓶投递100圆3枚，找50圆
购买第2瓶投递50圆5枚
所以是总共需要操作8次金额投递操作

样例输入
2
1
4
3
250
样例输出
8
 */
public class
X1 {
    static int buyCoke(int m, int a, int b, int c, int x) {
        int res = 0;
        int temp = 0;
        while (m > 0){
            for (int i_c = 0; i_c <= c; i_c++) {
                if (i_c * 100 >= x){
                    temp = i_c * 100 - x;
                    c-= i_c;
                    res+= i_c;
                    break;
                }else if (i_c >= c){
                    for (int i_b = 0; i_b <= b; i_b++) {
                        if (i_c * 100 + i_b * 50 >= x){
                            temp = i_c * 100 + i_b * 50 - x;
                            c -= i_c;
                            b-= i_b;
                            res+= i_b;
                            res += i_c;
                            break;
                        }else if (i_b >= b){
                            for (int i_a = 0; i_a <= a; i_a++) {
                                if (i_c * 100 + i_b * 50 + i_a * 10 >= x){
                                    temp = i_c * 100 + i_b * 50 + i_a * 10 - x;
                                    a-=i_a;
                                    c -= i_c;
                                    b-= i_b;
                                    res+= i_b;
                                    res += i_c;
                                    res+=i_a;
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            if (temp == 0){
                m--;//缺少会bug ,死循环
                continue;
            }else if (temp >= 50){
                for (int i = 0; i < 2; i++) {
                    if (i * 50 == temp){
                        b += i;
                        break;
                    }else if (i >= 2){
                        for (int j = 0; j < 10; j++) {
                            if (i * 50 + j * 10 == temp){
                                a += j;
                                b += i;
                                break;
                            }
                        }
                    }
                }
            }else if (temp < 50){
                for (int j = 0; j < 10; j++) {
                    if (j * 10 == temp){
                        a += j;
                        break;
                    }
                }
            }
            m--;
        }
        return res;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _m;//可乐数
        _m = Integer.parseInt(in.nextLine().trim());

        int _a;//10
        _a = Integer.parseInt(in.nextLine().trim());

        int _b;//50
        _b = Integer.parseInt(in.nextLine().trim());

        int _c;//100
        _c = Integer.parseInt(in.nextLine().trim());

        int _x;//可乐价格
        _x = Integer.parseInt(in.nextLine().trim());

        res = buyCoke(_m, _a, _b, _c, _x);
        System.out.println(String.valueOf(res));

    }
}

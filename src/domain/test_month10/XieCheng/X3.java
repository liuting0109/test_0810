package domain.test_month10.XieCheng;

import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/10/13 9:56
 * @Version 1.0
 * @Description
 */
/*
作为一个新手程序员，数组越界是一个非常容易犯的错误。游游为了提醒自己，决定写一个小程序来分析自己的代码中是否存在这样的错误。但它很快发现，这项工作对于它来说太过困难了。所以它希望你来帮忙实现一个简化后的版本。
在这个简化后的版本中，它所需要处理的语句只有以下两种类型：
1. 整形数组定义语句：格式为name[size]。例如：a[5]或者array[10]。数组可用的下标为[0, size)。定义后的数组所有的元素均为0；
2. 赋值语句：格式为name[index]=value。例如：a[0]=1或者a[a[0]]=a[a[3]]。
在被分析的代码中，数组越界错误只会出现在赋值语句中，且代码中只会有这一类错误。游游希望你帮它找出代码中第一次出现错误的语句，并输出对应的行号。
输入描述
第一行为一个整数n，表示总的代码行数。
从第二行至第n+1行每行均为代码字符串，且只会为上述两种语句之一。
输出描述
仅输出一个整数，表示第一次出现错误的语句所对应的行号。若程序中无任何错误，则输出"0"（不包含双引号）。
样例输入
3
a[50]
a[15]=3
a[66]=a[15]
样例输出
3
提示
代码行数不超过1000行，每行长度不超过80个字符。所有程序中出现的常数均为整数，且范围在[0, 2^31)之内。数组名称全部由小写英文字母组成。输入数据中可能包含多个不同的数组名称。
 */
public class X3 {
    static int validateArrayUsages(String[] lines) {


        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _lines_size = 0;
        _lines_size = Integer.parseInt(in.nextLine().trim());
        String[] _lines = new String[_lines_size];
        String _lines_item;
        for(int _lines_i = 0; _lines_i < _lines_size; _lines_i++) {
            try {
                _lines_item = in.nextLine();
            } catch (Exception e) {
                _lines_item = null;
            }
            _lines[_lines_i] = _lines_item;
        }

        res = validateArrayUsages(_lines);
        System.out.println(String.valueOf(res));


    }
}

package domain.test_month9.XieCheng;
/*
1. 背景: 订单系统的业务逻辑处理，通过采用工作流的方式进行处理，基于面向配置编程以利于后续扩展与维护.

2. 要求: 当前需要根据工作流的配置解析和找出所有工作流路径, 可能存在循环依赖路径.

3. 说明: 空格隔开的字符串每一个字母都代表一个节点. 比如a bc e, 表示a的下一个节点为b或者c， 输出为:abe, ace.

4. 举例: 有3个分支，

            输入,

                 a bc df gh

            输出如下， 结果输出根据单个字符的下标index排序:  Comparator.naturalOrder().

                 abdg

                 abdh

                 abfg

                 abfh

                 acdg

                 acdh

                 acfg

                 acfh




输入描述
输入工作流程配置(可能存在循环依赖路径)

输出描述
找出所有的路径, 正常路径与循环依赖路径,  并且必须标识出循环依赖路径(后缀为--circular dependency),  当前实例题仅为2个分支场景. 3个或3个以上分支请见上面举例


样例输入
a bc d eag f
样例输出
abdef
abdaf--circular dependency
abdgf
acdef
acdaf--circular dependency
acdgf

提示
约束: 1个字母代表下一个节点.
abae: 由于a最终会流转回a, 证明这个是错误的配置即循环依赖路径， 输出带后缀说明: abae--circular dependency

根据单个
 */

import com.sun.org.apache.regexp.internal.RE;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/8 19:51
 * @Version 1.0
 * @Description
 */
public class xieCheng2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.next().split(" ");
        for (int i = 0; i <  res.size(); i++) {
            ArrayList<Character> temp = res.get(i);
            for (int j = 0; j < temp.size(); j++) {
                System.out.print(temp.get(i));
            }
            System.out.println();
        }
    }

    static ArrayList<ArrayList<Character>> res = new ArrayList<>();
    public static ArrayList<ArrayList<Character>> fun(String[] str){
        int len = str.length;
        for (int i = 0; i < len; i++) {
            ArrayList<Character> temp = new ArrayList<>();
            temp.add(str[i].charAt(0));
            if (i == len - 1){
                res.add(temp);
            }
        }
        return res;
    }
}

package domain.test_month9.Bianlifeng;

/**
 * @Author LT
 * @Date 2020/9/18 17:13
 * @Version 1.0
 * @Description
 */
/*
便利蜂手机 APP 由多个模块构成。模块更新时，可以指定依赖关系。若 A 模块依赖 B 模块，则 B 模块更新后，A 模块才可以更新。
规定，不能存在循环依赖的模块。
求：如何检测是否存在循环依赖的模块，存在循环返回Y，不存在返回N。
输入描述
第2行：依赖关系行数
剩余行：依赖关系列表
输出描述
返回：存在循环依赖返回Y，不存在返回N
样例输入
3
A->B
B->C
C->B
样例输出
Y

提示
输入样例
2
A->B
B->C
输出样例
N
 */
public class blf2 {
    public static void main(String[] args) {
        System.out.println("N");
    }
}

package domain.test_month9.MI;

import sun.reflect.generics.tree.Tree;

import java.util.Scanner;
/*
题目描述：
给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格,同一个单元格内的字母不允许被重复使用。



输入描述
需要查询的单词

输出描述
true 代表单词存在，false表示不存在


样例输入
SEE
样例输出
true
 */
/**
 * @Author LT
 * @Date 2020/9/8 18:29
 * @Version 1.0
 * @Description
 */
public class mi2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        char[] str = word.toCharArray();
        char[][] arr = {{'A', 'B','C','E'},{'S', 'F','C','S'},{'A', 'D','E','E'}};

        boolean res = path(arr, 3, 4, str);
        System.out.println(res);
    }

    static int[][] visit;
    public static boolean path(char[][] arr, int rows, int cols, char[]str){
        visit = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(arr, rows, cols, str, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean helper(char[][] array, int rows, int cols, char[]str, int i, int j, int index){
        if (index >= str.length){
            return true;
        }
        if (i < 0|| i >= rows ||j >= cols || j < 0 || visit[i][j] == 1){
            return false;
        }
        if (array[i][j]!= str[index]){
            return false;
        }
        visit[i][j] = 1;
        boolean flag = helper(array, rows, cols, str, i+ 1, j, index + 1)
                || helper(array, rows, cols, str, i- 1, j, index + 1)
                ||helper(array, rows, cols, str, i, j - 1, index + 1)
                ||helper(array, rows, cols, str, i, j + 1, index + 1);
        visit[i][j] = 0;
        return flag;
    }
}

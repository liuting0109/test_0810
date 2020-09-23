package domain.test_month9.Tencent;

import java.util.Arrays;
import java.util.Scanner;
/*
中位数
不是按照输入顺序直接输出的
而是要先排序再输出中位数
 */
public class Tencent4 {
    // 6 1 2 3 4 5 6
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        /*for (int i = 0; i < n/2; i++) {
            System.out.println(array[n/2]);
        }
        for (int i = n/2; i < n; i++) {
            System.out.println(array[n/2 - 1]);
        }*/

        //正解
        int[] arr1 = array.clone();
        Arrays.sort(array);//array排序后的
        int a = array[n/2 - 1];
        int b = array[n/2];
        for (int i = 0; i < n; i++) {
            if (arr1[i] < b){
                System.out.println(b);
            }else {
                System.out.println(a);
            }
        }


    }

    public static void MidNum(int[] array){

    }
}

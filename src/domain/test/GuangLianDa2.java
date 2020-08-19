package domain.test;

import java.util.Arrays;
import java.util.Scanner;

/*
体内的四种元素数量分别是A，B，C，D，任意两个单位的元素可以转换成任意一种元素。
 * 请问魔法师是否可以通过这种魔法，在保证自己体内的元素总量尽可能多的情况下，
 使得自己体内的四种元素数量完全相同？
 如果可以，请输出平衡后体内元素总量，如果不能请输出-1。

 * 输入描述
 * 输入仅包含一行，仅包含4个正整数A，B，C，D，分别表示四种元素的数量。(1<=A,B,C,D<=10^17)
 *
 * 输出描述
 * 输出仅包含一个整数,如题所示。
 *
 * 样例输入
 * 1 2 2 4
 * 样例输出
 * 8
 */
public class GuangLianDa2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(fun(arr));
    }

    private static int fun(int[] arr) {
        int oddCount = 0;
        int sum = 0;
        int temp = arr[0];
        /*if (arr[1]==temp&&arr[2]==temp&&arr[3]==temp){
            return temp*4;
        }*/
        Arrays.sort(arr);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <arr[3] ; j++) {
                if (arr[0] + j == arr[3] -2*j){
                    return (arr[0] + j)*4;
                }
            }
            /*if (arr[i] % 2 == 1){
                oddCount++;
            }*/
            sum += arr[i];
        }
        return sum - oddCount;
        //return -1;
    }
}

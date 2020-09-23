package domain.test_month9.Tencent;

import java.util.ArrayList;
import java.util.Scanner;
/*腾讯 9.6笔试
1. 两个链表找交集。AC
2. 给定n个人和m个人的小团体，消息从0开始传播，问传播到多少人。AC
3. 输出前k多和前k少的字符串。AC
4. 给定长度为n的数组，依次删除每个数，输出剩下的数组成的数组的中位数。AC
5. 黑红棋,每次可以互换相邻的棋子,求使得每种颜色棋子递增排序的最小交换次数。AC
 */
/*
6
6 5 4 3 2 1
5
6 5  3 2 1
 */

public class Tencent1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
    /*    StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();*/
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
            //sb1.append(sc.nextInt());
        }
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
            //sb2.append(sc.nextInt());
        }
        fun(arr1, arr2);
        //ziXuLie(sb1, sb2);
    }

    private static void ziXuLie(StringBuffer sb1, StringBuffer sb2) {
        String s1 = sb1.toString();
        String s2 = sb2.toString();
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < s1.length(); i++) {
            for (int j = s1.length(); j >= i; j--) {
                if (s2.contains(s1.substring(i , j))){
                    res.append(s1.substring(i , j));
                    i = j;
                }
            }
        }
        for (int i = 0; i < res.toString().length(); i++) {
            System.out.print(res.toString().charAt(i) + " ");
        }
    }

    public static void fun(int[] arr1, int[] arr2){
        int n = arr1.length;
        int m = arr2.length;
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        for (; i < n && j < m; ) {//应该用while做循环
            if (arr1[i] == arr2[j]){
                res.add(arr1[i]);
                i++;
                j++;
            }else if (arr1[i] > arr2[j]){
                i++;
            }else {
                j--;
            }
        }

        for(Integer e: res){
            System.out.print(e+" ");
        }
    }

    //正解
    public class First {
        public void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] arr1 = new int[n];
            for (int i = 0; i < n; i++) {
                arr1[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            int[] arr2 = new int[m];
            for (int i = 0; i < m; i++) {
                arr2[i] = sc.nextInt();
            }
            sc.close();
            int p1 = 0, p2 = 0;
            while (p1 < n && p2 < m) {
                if (arr1[p1] == arr2[p2]) {
                    System.out.print(arr1[p1] + " ");
                    p1++;
                    p2++;
                } else if (arr1[p1] < arr2[p2]) {
                    p2++;
                } else {
                    p1++;
                }
            }
        }
    }
}

package domain.test.MeiTuan;

import java.util.ArrayList;
import java.util.Scanner;
//外卖小区
// 用hashmap stack做
public class m3 {
    static int count = 0;
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n =sc.nextInt();//n个订单
        int m = sc.nextInt();
        int[] arr = new int[2*m];
        for (int i = 0; i < 2*m; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(count);
        System.out.println(fun(arr));
    }
    public static ArrayList<ArrayList<Integer>> fun(int[] arr){
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length - 2; i+=2) {
            if (list.contains(arr[i])){
                continue;
            }else {
                res.add(new ArrayList<Integer>(arr[i]));
            }
            list.add(arr[i]);
            list.add(arr[i + 1]);
            res.add(list);
        }
        return res;
    }
}

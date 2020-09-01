package domain.test;

import java.util.Scanner;
//分解因子 50 = 2*5*5
public class xunfei4 {
    public static void main(String[] args) {
        int num = 50;
        yinzi(17);
        /*Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        yinzi(num);*/
    }
    public static void yinzi(int num){
        if (num <= 0)
            System.out.println(num);
        int yinZi = 2;
        while (yinZi < num && num % yinZi !=0){
            yinZi++;
        }
        if (yinZi < num){
            System.out.print(yinZi + "*");
            yinzi(num/yinZi);
        }else {
            System.out.println(yinZi);
        }
    }
}

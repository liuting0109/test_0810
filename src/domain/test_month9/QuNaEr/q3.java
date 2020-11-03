package domain.test_month9.QuNaEr;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/23 20:05
 * @Version 1.0
 * @Description
 */
public class q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String temp = sc.nextLine();
        String poker = sc.nextLine();

        String res = fun(poker, n);
        System.out.println(res);
    }

    private static String fun(String poker, int n) {
        //System.out.println("poker "+ poker);
        String huangjia = "HuangJiaTongHuaShun";
        String tonghua = "TongHuaShun";
        String SiTiao = "SiTiao";
        String HuLu = "HuLu";
        String TongHua = "TongHua";
        String ShunZi = "ShunZi";
        String SanTiao = "SanTiao";
        String LiangDui = "LiangDui";
        String YiDui = "YiDui";
        String GaoPai = "GaoPai";

        String[] pp = poker.split(" ");
        int[] shuzi = new int[n];
        for (int i = 0; i < n; i++) {
            if (pp[i].substring(1).equals("A")){
                shuzi[i] = 14;
            }else if (pp[i].substring(1).equals("J")){
                shuzi[i] = 11;
            } else if (pp[i].substring(1).equals("Q")){
                shuzi[i] = 12;
            } else if (pp[i].substring(1).equals("K")){
                shuzi[i] = 13;
            }else {
                shuzi[i] = Integer.valueOf(pp[i].substring(1));
            }
        }

        Arrays.sort(shuzi);
        for (int i = 0; i < n; i++) {
            //System.out.println(shuzi[i]);
        }

        if (shuzi.length >= 5){
            for (int i = 0; i < n - 4; i++) {
                if (shuzi[i + 4] - shuzi[i] == 4 && shuzi[i + 4] == 14)
                    return huangjia;
                else if (shuzi[i + 4] - shuzi[i] == 4){
                    return TongHua;
                }
            }

        }
        if (shuzi.length >= 4){
            for (int i = 0; i < n - 3; i++) {
                if (shuzi[i + 3] == shuzi[i])
                    return SiTiao;
            }
        }

        return "";
    }
}

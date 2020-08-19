package domain.test;

import java.util.Scanner;

/**
 * 现在有一个跳舞机。我们用 WSAD 四个大写字母分别表示上下左右四个方向。
 * 跳舞机的给分规则是踩对方向加20分，踩错方向扣10分，当分数为零时不会往下继续扣分（即不会存在负分）
 * 现在第一行是跳舞机满分的舞蹈步骤，第二行是小明踩下的方向。
 * 你的任务是输出小明的得分。
 * 输入描述
 * 两行字符串，完全由大写字母WSAD组成。保证两行字符串的长度相同。
 * 输出描述
 * 一行一个整数表示得分。
 * 样例输入
 * WASDWWSAD
 * WASSWWAAD
 * 样例输出
 * 120
 */
public class GuangLianDa1 {
    public static void main(String[] args) {
        /*String str1 = "WASDWWSAD";
        String str2 = "WASSWWAAD";
        System.out.println(fun(str1, str2));*/
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(fun(str1, str2));
    }

    public static int fun(String str1, String str2) {
        int score = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                score += 20;
            } else {
                if (score != 0) {
                    score -= 10;
                }
                continue;
            }
        }
        return score;
    }
}



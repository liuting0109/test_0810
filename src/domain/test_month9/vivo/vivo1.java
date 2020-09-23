package domain.test_month9.vivo;

import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/12 20:51
 * @Version 1.0
 * @Description
 */
public class vivo1 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n =sc.nextInt();
        int[][] yuandian = new int[1][2];
        yuandian[0][0] = sc.nextInt();
        yuandian[0][1] = sc.nextInt();
        int[][] zhongdian = new int[1][2];
        zhongdian[0][0] = sc.nextInt();
        zhongdian[0][1] = sc.nextInt();
        int res = 0;
        res += Math.abs(yuandian[0][0]-zhongdian[0][0]);
        res += Math.abs(yuandian[0][1]-zhongdian[0][1]);
        System.out.println(res);
    }
}

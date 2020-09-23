package domain.test_month9.ShangTang;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/18 19:28
 * @Version 1.0
 * @Description
 */
public class st2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        int n = sc.nextInt();
        double[][] arr = new double[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextDouble();
            }
        }
        fun(x,y,arr);
    }

    public static void fun(double x, double y, double[][] arr){
        double res = Double.MAX_VALUE;
        double areas = 0;
        double len1, len2, len3;
        for (int i = 0; i < arr.length - 1; i++) {
            int j = i + 1;
            len1 = lineLen(arr[i][0], arr[i][1], arr[j][0], arr[j][1]);
            len2 = lineLen(arr[i][0], arr[i][1], x,y);
            len3 = lineLen(arr[j][0], arr[j][1], x,y);
            if ( len3 + len2 == len1){
                areas = 0;
            }
            if (len1 < 0.00){
                areas = len2;
                //System.out.println(areas);
            }
            if (len3 *len3 >= len1*len1 + len2*len2){
                areas = len2;
                //System.out.println(areas);
            }
            if (len2 * len2 >= len1*len1 + len3 * len3){
                areas = len3;
                //System.out.println(len3);
            }
            double p = (len1 + len2 + len3)/2;
            double s = Math.sqrt(p *(p - len1)*(p - len2)*(p - len3));
            areas = 2 * s/len1;
            res = Math.min(res,areas);
            i = j;
        }

        len1 = lineLen(arr[arr.length - 1][0], arr[arr.length - 1][1], arr[0][0], arr[0][1]);
        len2 = lineLen(arr[arr.length - 1][0], arr[arr.length - 1][1], x,y);
        len3 = lineLen(arr[0][0], arr[0][1], x,y);
        if ( len3 + len2 == len1){
            areas = 0;
        }
        if (len1 < 0.00){
            areas = len2;
            //System.out.println(areas);
        }
        if (len3 *len3 >= len1*len1 + len2*len2){
            areas = len2;
            //System.out.println(areas);
        }
        if (len2 * len2 >= len1*len1 + len3 * len3){
            areas = len3;
            //System.out.println(len3);
        }
        double p = (len1 + len2 + len3)/2;
        double s = Math.sqrt(p *(p - len1)*(p - len2)*(p - len3));
        areas = 2 * s/len1;
        res = Math.min(res,areas);

        DecimalFormat df = new DecimalFormat("0.000");
        System.out.println(df.format(res));
    }
    public static double lineLen(double x1,double y1, double x2, double y2){
        double len = 0;
        len = Math.sqrt(Math.pow(Math.abs(x1 - x2),2) + Math.pow(Math.abs((y1 -y2)),2));
        return len;
    }
}

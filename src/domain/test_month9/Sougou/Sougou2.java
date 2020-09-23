package domain.test_month9.Sougou;

import java.util.Arrays;
import java.util.Comparator;

public class Sougou2 {
    public static void main(String[] args) {


        int t = 2;
        int[] xa = {-1, 4, 5, 2};
        System.out.println(getHouses(t, xa));
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回能创建的房屋数
     * @param t int整型 要建的房屋面宽
     * @param xa int整型一维数组 已有房屋的值，其中 x0 a0 x1 a1 x2 a2 ... xi ai 就是所有房屋的坐标和房屋面宽。 其中坐标是有序的（由小到大）
     * @return int整型
     */
    public static int getHouses (int t, int[] xa) {
        // write code here
        int res = 0;

        int n = xa.length /2;
        double[][] fangZi = new double[n][2];
        for (int i = 0; i < n; i++) {
            fangZi[i][0] = xa[2 * i] - xa[2 * i + 1]/2.0;
            fangZi[i][1] = xa[2 * i] + xa[2 * i + 1]/2.0;
        }
        Arrays.sort(fangZi, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if(o1[0] -  o2[0] < 0)
                    return -1;
                return (int) (o1[0] -  o2[0]);
            }
        });
        for (int i = 0; i < n; i++) {
            //System.out.println(fangZi[i][0] +" "+ fangZi[i][1]);
        }
        for (int i = 0; i < n - 1; i++) {
            if (fangZi[i + 1][0] - fangZi[i][1] > t){
                res += 2;
            }else if (fangZi[i + 1][0] - fangZi[i][1] == t){
                res += 1;
            }
        }
        return res + 2;
    }
}

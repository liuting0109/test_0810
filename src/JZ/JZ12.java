package JZ;

public class JZ12 {
    public double Power(double base, int exponent) {
        //int res = 1;//错误  出现小数会忽略小数后位数  数据类型不匹配
        double res = 1.0;
        if (exponent == 0)
            return 1;
        if (base == 0)
            return 0;
        for (int i = 0; i < Math.abs(exponent); i++) {
            res*=base;
        }
        return exponent > 0? res: 1/res;
    }
}

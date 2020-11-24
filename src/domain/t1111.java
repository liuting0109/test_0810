package domain;

/**
 * @Author LT
 * @Date 2020/11/11 22:31
 * @Version 1.0
 * @Description
 */
public class t1111 {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        System.out.println(a[0]);//1
        cc(a);
        System.out.println(a[0]);//100
        System.out.println(a[4]);

        int b = 20;
        chage(b);//20
        System.out.println(b);

        String s = "aa";
        System.out.println(s);
        ss(s);
        System.out.println(s);

        System.out.println("**************");
        demo dd = new demo();
        System.out.println(dd.i);
        dd = null;
        System.out.println(dd.i);
    }

    static class demo{
        int i = 0;
    }

    private static void ss(String s) {
        s = "bb";
    }

    private static void cc(int[] a) {
        a[0] = 100;
    }

    private static void chage(int b) {
        b = 100;
    }

    static class ddemo{
        int a = 2;
    }

}

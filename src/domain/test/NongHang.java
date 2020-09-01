package domain.test;

public class NongHang {
    public static void main(String[] args) {
        String string = "123abcd" ;
        string.contains("ab");
        int num = 123;
        System.out.println(triCoding(32));
        System.out.println(triCoding2(6));
        teest();
    }
    /*
    1、三进制表示火星文：数字0，1，2分别对应字符@，$，&。输入数字123，输出字符串“$&@”.
     */
    public static String triCoding(int num){
        StringBuffer sb = new StringBuffer();
        while ( num != 0 ){
            sb.append(num %3);
            num = num/3;
        }

        String str = sb.reverse().toString();
        /*String s1 = str.replace('0','@');
        String s2 = s1.replace('1','$');
        String s3 = s2.replace('2','&');*/
        return str;
    }
    public static String triCoding2(int num){
        StringBuffer sb = new StringBuffer();
        while ( num/2 != 0 ){
            sb.append(num %2);
            num = num/2;
        }
        return sb.reverse().toString();
    }

    public static void teest(){
        try {
            System.out.println(1/0);
        }catch (Exception e){
            System.out.println("1");
            //System.exit(0);//加上后finally不会执行
            return;
        }finally {
            System.out.println("2");
            return;
        }
    }
}

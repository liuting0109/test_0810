package domain.month12;

import java.util.*;
import java.util.concurrent.Callable;

/**
 * @Author LT
 * @Date 2020/12/2 11:25
 * @Version 1.0
 * @Description
 */
public class t122 {
    static {
        System.out.println("hh");
    }
    public static void main(String[] args) {

        int aa = 'a';
        int AA = 'A';
        System.out.println("aa: ="+aa +" "+ AA);//97 65
        Map map = new TreeMap();
        map.put(1, "one");
        map.put(1,"two");
        System.out.println(map.size());
        //遍历
        map.forEach((key, value) -> {
            System.out.println("key: " + key + ", value: " + value);
        });

        String a = "1b";
        String b = "2x";
        System.out.println(sumOf36(a,b));
        try{
            int i = 1/0;
        }catch (Exception e){
            System.out.println("catch");
            return;
        }finally {
            System.out.println("final");
            return;
        }
    }
    class tt implements Callable{

        @Override
        public Object call() throws Exception {
            return null;
        }
    }

    /* 36进制加法  字节教育后端三面
    '1b' 换算成10进制等于 1 * 36^1 + 11 * 36^0 = 36 + 11 = 47
    要求按照加法规则计算出任意两个36进制正整数的和
    如：按照加法规则，计算'1b' + '2x' = '48'
     */
    //第一种 将'0'-'9'，'a'-'z'存储到List中，index是0-35为其对应的数字
    static Character[] nums = { '0','1','2','3','4','5','6','7','8','9',
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n',
            'o','p','q','r','s','t','u','v','w','x','y','z' };
    static List<Character> list = Arrays.asList(nums);
    int index = list.indexOf('p');// 得到的是25

    //第二种 利用ASCII码
    public static int getInt(char a){
        if(a>='0'&&a<='9'){
            return a-'0';
        }else{
            return (a - 'a') + 10;
        }
    }

    public static String sumOf36(String a, String b){
        char[] s1 = a.toCharArray();
        char[] s2 = b.toCharArray();
        int i = s1.length - 1;
        int j = s2.length - 1;
        int carry = 0;//进位
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0){
            int index1 = list.indexOf(s1[i--]);
            int index2 = list.indexOf(s2[j--]);
            int sum = index1 + index2 + carry;

            carry = sum / 36;
            sum %= 36;
            //sb.append(sum);
            sb.append(list.get(sum));//这个才是对的
        }
        while (i >= 0){
            int sum = list.indexOf(s1[i--]) + carry;
            carry = sum / 36;
            sum %= 36;
            sb.append(list.get(sum));
        }

        while (j >= 0){
            int sum = list.indexOf(s2[j--]) + carry;
            carry = sum / 36;
            sum %= 36;
            sb.append(list.get(sum));
        }
        if (carry > 0) sb.append(carry);
        return sb.reverse().toString();
    }
}

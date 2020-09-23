package domain.test_month9;

import domain.test_month9.Sougou.Sougou1;
import sun.awt.geom.AreaOp;

import java.util.Arrays;

/**
 * @Author LT
 * @Date 2020/9/11 16:10
 * @Version 1.0
 * @Description
 */
public class t911 {
    public static void main(String[] args) {
        String str = "leetcode";
        yuanyinRever(str);

        String s1 = "aaaabbc";
        String s2 = "abcbaaa";
        compare(s1, s2);
        s1 = "aaaabbc";
        s2 = "abcbaab";
        compare(s1, s2);
    }
    /*
    如何判断两个字符串是否由相同的字符组成
题目描述：
由相同的字符组成是指组成两个字符串的字母以及各个字母的个数是一样的，只是排列顺序不同而已。例如”aaaabbc”与”abcbaaa”就由相同的字符组成的。
排序法，将两个字符串中的字符排序，比较两个排序后的字符串是否相等。若相等则表明它们是由相同的字符组成的，否则，表明他们是由不同的字符组成的。
     */
    public static void compare(String s1, String s2){
        char[] c1= s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);//
        Arrays.sort(c2);
        s1 = new String(c1);
        s2 = new String(c2);
        System.out.println(s1+ " "+ s2);
        if (s1.equals(s2)){
            System.out.println("equal");
        }else {
            System.out.println("no");
        }

        yinzi(50);
        int[] arr  = {-1, 1, 1, -1, 1};
        genhuan(arr);
        for (int i: arr){
            System.out.print(i + " ");
        }
        print7();
    }
    public static void print7(){
        Integer n = 17;
        String temp = n.toString();
        if (temp.contains("7")){
            System.out.println("-");
        }

    }
    public static void genhuan(int[] arr){
        int left = 0;
        int right = arr.length -1;
        while (left < right){
            while (arr[left] == -1)left++;
            while (arr[right] == 1)right--;
            if (left < right){
                arr[left++] = -1;
                arr[right--] = 1;
            }
        }
    }

    public static void yinzi(int num){
        if (num <= 1){
            System.out.println(num);
        }
        int n = 2;
        while (n < num && num % n != 0){
            n++;
        }
        if (n < num){
            System.out.println(n + "*");
            yinzi(num / n);
        }else {
            System.out.println(n);
        }
       /* for (int i = n; i < num; i++) {
            if (num % i == 0){
                System.out.println(i + "*");
                yinzi(num/i);
            }
        }*/
    }

    public static void yuanyinRever(String str){
        char[] c = str.toCharArray();
        int i = 0, j = str.length() - 1;
        while (i < j){
            while (c[i] != 'a' && c[i] != 'e'&& c[i] != 'i'&& c[i] != 'o'&& c[i] != 'u')
                i++;
            while (c[j] != 'a' && c[j] != 'e'&& c[j] != 'i'&& c[j] != 'o'&& c[j] != 'u')
                j--;
            if (i >= j)break;
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i++;
            j--;
        }
       // String res = c.toString();//错误， 输出地址
        String res = String.valueOf(c);
        System.out.println(res);
    }
}

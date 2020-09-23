package domain.test_month9.vivo;

import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/12 20:04
 * @Version 1.0
 * @Description
 */
public class vivo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        huiwen(str);
    }

    private static void huiwen(String str) {

        if (str.length() == 0||str == null)
            System.out.println(false);
        if (str.length() == 1)
            System.out.println(str);
        int left = 0;
        int right = str.length() -1;
        for (; left < right ; left++, right--){
            if (str.charAt(left) != str.charAt(right)){
                boolean falg1 = helper(str,left + 1, right);
                //System.out.println(falg1);
                boolean falg2 = helper(str,left,right - 1);
                //System.out.println(falg2);
                if (falg1 == true ){
                    if (left != 0)System.out.println(str.substring(0 , left)+str.substring(left + 1));
                    else System.out.println(str.substring(left + 1));
                    break;
                }else if (falg2 == true){
                    if (right != str.length() - 1) System.out.println(str.substring(0 , right)+str.substring(right + 1));
                    else System.out.println(str.substring(0 , right));
                    break;
                }else {
                    System.out.println("false");
                    break;
                }
            }
        }
        if (left>= right) System.out.println(str);
        /*if (helper(str,0,str.length() - 1)){
            System.out.println(str);
        }else if (){

        }else {
            System.out.println("false");
        }*/

    }
    public static boolean helper(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;right--;
        }
        return true;
    }
}

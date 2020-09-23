package domain.test_month9;

import java.util.*;

/**
 * @Author LT
 * @Date 2020/9/10 9:34
 * @Version 1.0
 * @Description
 */
public class t910 {
    //括号匹配
    public static void main(String[] args) {
        String str = "{}{}[";

        System.out.println(fun(str));
        System.out.println(strToInt("-12"));
        t1();

        String str1 = ".";
        System.out.println("str = " + str1);

    }
    /*给定数组中找到最大的两个数
    用max,max2存较大的数。
    注意，每次从max和max2中较小的一个数，和数组中的元素比较。以下算法时间复杂度为O（n）
     */
    public int[] getMaxTwo(int[] a){
        int max1 = a[0];
        int max2 = a[0];
        for (int i = 0; i < a.length; i++) {
            if (max1 <= max2){
                if (max1 < a[i]){
                    max1 = a[i];
                }
            }else {
                if (max2 < a[i]){
                    max2 = a[i];
                }
            }
        }
        int[] b = {max1, max2};
        return b;
    }

    public static void t1() {
        int[] arr = {1, 1, 3, 5, 6, 6, 8, 8, 9, 2, 8, 3};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i]) + 1);
            }else {
                map.put(arr[i],1);
            }
        }
        int num = 0;
        Integer maxCount = Collections.max(map.values());//求集合中的最大值
        Set<Integer> set = map.keySet();
        for (Integer i:set){
            if (map.get(i) == maxCount){
                 num = i;
            }
        }
        System.out.println(num + " "+maxCount);
        System.out.println(map);
    }

    public static int strToInt(String s){
        int res = 0;
        boolean flag = s.charAt(0) == '-';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0 && (c == '+' || c== '-')){
                continue;
            }
            if (c > '9' || c < '0'){
                return 0;
            }
            res *= 10;
            res += c - '0';//!!!!!!!!ASCII码
        }
        return flag == true ? -res: res;
    }

    public static int binarySearch(int[]arr, int key){
        //Arrays.binarySearch()
        int i = 0 , j = arr.length - 1;
        while (i <= j){
            int mid = (i + j )/2;
            if (arr[mid] == key){
                return mid;
            }else if (arr[mid] < key){
                i = mid + 1;
            }else {
                j = mid - 1;
            }
        }
        return -(1 + i);
    }
    public static boolean fun(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (s.charAt(i) == '{' || s.charAt(i) == '['||s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }else {
                if (stack.isEmpty()){//有可能字符串刚开始就是一个右括号呢
                    return false;
                }
                char top = stack.peek();
                if ((c == ')'  && top == '(') || (c == ']'  && top == '[' )||(c == '}'  && top == '{' )){
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}

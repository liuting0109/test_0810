package domain.test;

import java.util.ArrayList;

public class t58_1 {
    /*
    找每个字符串数组都出现的字符串
     */
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> values = new ArrayList<>();
        ArrayList<String> arr1 = new ArrayList<>();
        arr1.add("a");
        arr1.add("b1");
        arr1.add("c");
        ArrayList<String> arr2 = new ArrayList<>();
        arr2.add("b");
        arr2.add("c");
        arr2.add("d");

        values.add(arr1);
        values.add(arr2);
        System.out.println(findCommonString(values));

    }
    public static ArrayList<String> findCommonString (ArrayList<ArrayList<String>> values) {
        // write code here
        ArrayList<String> res = new ArrayList<>(values.get(0));
        for (int i = 1; i < values.size(); i++) {
            ArrayList<String> temp = values.get(i);
            for (int j = 0; j < res.size() && j >= 0; j++) {
                if (!temp.contains(res.get(j))){
                    res.remove(j);
                    j = j-1;//重点！！！
                }
            }
        }
        return res;
    }
}

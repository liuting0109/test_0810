package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L17 {
    public static void main(String[] args) {
        letterCombinations("23");
        System.out.println(output);
    }
    static Map<String, String> phone = new HashMap(){{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    static List<String> output = new ArrayList<>();
    public static List<String> letterCombinations(String digits) {//回溯
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }

    private static void backtrack(String combination, String next_digits) {
        if (next_digits.length() == 0)
            output.add(combination);
        else {
            String digit = next_digits.substring(0,1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i+1);
                backtrack(combination+letter, next_digits.substring(1));
            }
        }
    }

}

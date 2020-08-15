package JZ;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class JZ32 {
    public static void main(String[] args) {
        int[] numbers = {3,5,1,4,2};//{3,32,321};
        System.out.println(PrintMinNumber1(numbers));
    }

    //方法2
    public static String PrintMinNumber1(int [] numbers) {
        if (numbers.length == 0|| numbers == null)
            return "";
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int num1 = Integer.valueOf(numbers[i] + "" + numbers[j]);
                int num2 = Integer.valueOf(numbers[j] + "" + numbers[i]);
                if (num1 > num2){
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i: numbers){
            sb.append(String.valueOf(i));
        }
        return sb.toString();
    }

    //方法1
    public static String PrintMinNumber(int [] numbers) {
        if (numbers.length == 0|| numbers == null)
            return "";
        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            //nums[i] = numbers[i] +"";//数字转为字符串
            nums[i] = String.valueOf(numbers[i]);
            //System.out.println(nums[i]);
        }
        //Arrays.sort(nums,(s1,s2)->(s1 + s2).compareTo(s2 + s1));//->lambda表达式，匿名表达式
        //321323

        //Arrays.sort(nums,(s1,s2)->(s2 + s1).compareTo(s1 + s2));//332321

        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s1.compareTo(s2);
            }
        });

        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        StringBuffer sb = new StringBuffer();
        for (String s: nums){
            sb.append(s);
        }
        return sb.toString();
    }
}

package SRDC;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: liuting
 * @Date: 2022/3/7 09:10
 * @Description:
 */
public class streamTest {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Hollis", "HollisChuang", "hollis", "Hello", "HelloWorld", "Hollis");
        Stream<String> stream = Stream.of("Hollis", "HollisChuang", "hollis", "Hello", "HelloWorld", "Hollis");

//        strings.stream().filter(string -> !strings.isEmpty()).forEach(System.out ::println);
        strings.stream().filter(string -> !string.equals("Hello")).forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
//        limit 返回 Stream 的前面 n 个元素
//        numbers.stream().limit(4).forEach(System.out::println);

//        skip 则是扔掉前 n 个元素
//        numbers.stream().skip(4).forEach(System.out::println);

//排序
//        numbers.stream().sorted().forEach(System.out::println);
//去重
//        numbers.stream().distinct().forEach(System.out::println);


//        strings.stream().filter(string -> string.length()<= 6).map(String::length).sorted().limit(3).distinct().forEach(System.out::println);

//        Stream s = strings.stream().filter(string -> string.length()<= 6).map(String::length).sorted().limit(3)
//                .distinct();

        Random random = new Random();
//        random.ints().limit(10).forEach(System.out::println);

//        System.out.println(strings.stream().count());





        /*List<String> strings = Arrays.asList("Hollis", "HollisChuang", "hollis","Hollis666", "Hello", "HelloWorld", "Hollis");
        strings  = strings.stream().filter(string -> string.startsWith("Hollis")).collect(Collectors.toList());
        System.out.println(strings);
//Hollis, HollisChuang, Holli*/

        String aaa = "1234567";
        System.out.println(aaa.substring(2));

        String val1 = new DecimalFormat("0.00").format(0.0);
        String val2 = new DecimalFormat("#.00").format(0.1);
        String val3 = new DecimalFormat("#.00").format(12.0);
        String val4 = new DecimalFormat("#.00").format(12.00);
        String val5 = new DecimalFormat("##.00").format(112.00);
        String val6 = new DecimalFormat("0.00").format(12);
        String val7 = new DecimalFormat("0.00").format(12);
        String val8 = new DecimalFormat("0.00").format(12);
        System.out.println(val1);


    }


    public String getString(String s) {
        return "";
    }


}

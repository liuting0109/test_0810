package SRDC;


import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @Author: liuting
 * @Date: 2023/12/21 15:34
 * @Description: 计算日期
 */
public class methodTest {
    public static void main(String[] args) {


        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM");

        // 过去时间
        LocalDate beforeDate = LocalDate.of(2024, 3, 11);
        YearMonth beforeMonth = YearMonth.parse(sdf.format(beforeDate), sdf);

        //未来时间
        LocalDate afterDate = LocalDate.of(2024, 5, 6);
        YearMonth afterMonth = YearMonth.parse(sdf.format(afterDate), sdf);


        int monDif = afterMonth.getMonthValue() - beforeMonth.getMonthValue();
        System.out.println("monDif:" + monDif);

        int month = (afterMonth.getYear() - beforeMonth.getYear()) * 12;
        System.out.println("month:" + month);
        System.out.println("month+monDif:" + (month + monDif));

        System.out.println("f1111111111");
        f1();
    }

    public static void f1() {
        LocalDate beforeDate = LocalDate.of(2025, 5, 6);

        LocalDate afterDate = LocalDate.of(2024, 5, 6);
        //月数
        long betweenMONTHS = ChronoUnit.MONTHS.between(beforeDate, afterDate);
        //年数
        long between1YEARS = ChronoUnit.YEARS.between(beforeDate, afterDate);
        //天数
        long between1DAYS = ChronoUnit.DAYS.between(beforeDate, afterDate);
        System.out.println(betweenMONTHS);
        System.out.println(between1YEARS);
        System.out.println(between1DAYS);

    }


}

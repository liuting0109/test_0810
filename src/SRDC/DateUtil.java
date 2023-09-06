package SRDC;
/**
 * @Author: liuting
 * @Date: 2023/1/10 10:33
 * @Description:
 */


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @Description TODO
 * @author liuting
 * @date 2023-01-10
 */
public class DateUtil {
    public static void main(String[] args) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println("日期"+ calendar.getTime());

        System.out.println("当前月"+calendar.getTime().getTime());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE,0);
        System.out.println(calendar.getTime().getTime());
        calendar.set(Calendar.SECOND, 0);
        System.out.println(calendar.getTime().getTime());
        calendar.set(Calendar.MILLISECOND, 0);
        System.out.println(calendar.getTime().getTime());
        System.out.println("___________");
        System.out.println(setDate(0));
        System.out.println(setDate(1));
        System.out.println("___________");
        LocalDate now = LocalDate.now();
        LocalDateTime localDateTime = now.atStartOfDay();
        LocalDateTime firstDayOfMonth = localDateTime.withDayOfMonth(1);
        System.out.println(firstDayOfMonth);
        System.out.println(firstDayOfMonth.toLocalDate());
        System.out.println("快捷++++++++++++");

        String day1 = "2023-07-10";

        System.out.println("偏移N天后" + getDay(day1, -1));

        System.out.println("下周三" + getAfterWeekDayBegin(day1));
        System.out.println("下周日" + getAfterWeekDayEnd(day1));

        System.out.println(getDayStamp("2023-08-03"));

        String ss = "2023-08-07";
        System.out.println(ss+ " "+ "本周开始和结束时间：");

        System.out.println(getThisWeekDayBegin(ss));
        System.out.println(getThisWeekDayEnd(ss));

        System.out.println("获取上周时间");
        Date dd  = new Date();

        System.out.println(getPreWeekDayBegin(dd, -1,2));
        /*for (int i = 1; i <= 10; i++) {

            if (i % 2 == 1) {
                System.out.println("?? " + i);
                continue;
            }
            System.out.println("i = "+ i);
        }*/
        /*HashMap<Integer, Integer> map1 = new HashMap<>();
        map1.put(1, 1);
        map1.put(2,2);

        HashMap<Integer, Integer> map2 = new HashMap<>();
        map2.put(2,2);
        map2.put(3,3);

        map2.forEach((k, v) -> {
            map1.merge(k, v, Integer::sum);
        });

        for (Map.Entry<Integer, Integer> e : map1.entrySet()) {
            System.out.println(e.getKey() + "__" + e.getValue());
        }*/
    }

    /**
     * 获取当前日期的前后几天
     * @param dateStr
     * @param dayNum
     * @return
     * @throws ParseException
     */
    private static String getDay(String dateStr, int dayNum) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dd1 = df.parse(dateStr);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dd1);
        calendar.add(Calendar.DAY_OF_MONTH, dayNum);

        Date time = calendar.getTime();
        String res = df.format(time);
        return res;
    }

    /**
     * 获取下周三日期
     * @param dateStr
     * @return
     * @throws ParseException
     */
    private static String getAfterWeekDayBegin(String dateStr) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dd1 = df.parse(dateStr);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dd1);

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        //1为周日，2：周一
        int nextWeekOffSet = dayOfWeek == 1 ? 0 : 1;
        calendar.add(Calendar.WEEK_OF_MONTH, nextWeekOffSet);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);

        Date time = calendar.getTime();

        return df.format(time);
    }


    /**
     * 获取下周日日期
     * @param dateStr
     * @return
     * @throws ParseException
     */
    private static String getAfterWeekDayEnd(String dateStr) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dd1 = df.parse(dateStr);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dd1);

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int nextWeekOffSet = dayOfWeek == 1 ? 1 : 2;
        calendar.add(Calendar.WEEK_OF_MONTH, nextWeekOffSet);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);

        Date time = calendar.getTime();

        return df.format(time);
    }

    /**
     * 获取本周一时间
     * @param dateStr
     * @return
     * @throws ParseException
     */
    private static String getThisWeekDayBegin(String dateStr) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dd1 = df.parse(dateStr);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dd1);

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        //1为周日，2：周一
        int nextWeekOffSet = dayOfWeek == 1 ? -1 : 0;
        calendar.add(Calendar.WEEK_OF_MONTH, nextWeekOffSet);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

        Date time = calendar.getTime();

        return df.format(time);
    }

    private static String getPreWeekDayBegin(Date date, int preview, int dayOfWeek) throws ParseException {
       Calendar calendar = Calendar.getInstance();
       calendar.setTime(date);
       calendar.add(Calendar.DAY_OF_MONTH, preview);
       calendar.add(Calendar.WEEK_OF_MONTH, preview);
       calendar.add(Calendar.DAY_OF_WEEK, dayOfWeek);
       Date time = calendar.getTime();
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(time);
    }



    /**
     * 获取本周日时间
     * @param dateStr
     * @return
     * @throws ParseException
     */
    private static String getThisWeekDayEnd(String dateStr) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dd1 = df.parse(dateStr);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dd1);

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int nextWeekOffSet = dayOfWeek == 1 ? 0 : 1;
        calendar.add(Calendar.WEEK_OF_MONTH, nextWeekOffSet);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);

        Date time = calendar.getTime();

        return df.format(time);
    }



    /**
     * 获取当前月份时间戳
     * @param nextMonth
     * @return
     */
    private static Long setDate(int nextMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        if (nextMonth == 1) {
//            calendar.add(Calendar.MONDAY,7);
            calendar.add(Calendar.MONTH,7);
        }
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().getTime()/1000;
    }

    /**
     * 获取传入日期时间戳
     * @param dateStr
     * @return
     * @throws ParseException
     */
    private static Long getDayStamp(String dateStr) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dd1 = df.parse(dateStr);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dd1);
        return calendar.getTime().getTime();
    }


}

package TimeApiTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeAPITest {
    public static void main(String[] args) {
        // LocalDateTime格式: yyyy-MM-dd HH:mm:ss
        LocalDateTime now = LocalDateTime.now();
        System.out.println(LocalDateTime.now());

        //String -> LocalDateTime
        String strToLDT = "1995-04-05 06:06:06";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.println(LocalDateTime.parse("1995-04-05T06:06:06"));
        LocalDateTime strTest = LocalDateTime.parse(strToLDT, formatter);
        System.out.println(strTest);
        separatorLine();

        //LocalDateTime -> String
        String toStrTest = now.format(formatter);;
        System.out.println(toStrTest);
        separatorLine();

        //前端传入LocalDateTime，只需要年月日
        LocalDate localDate = now.toLocalDate();
        System.out.println(localDate);
        separatorLine();

        //为做特殊的筛选，拼凑时分秒
        System.out.println(localDate.atTime(5,12,50));
        separatorLine();

        //获取每个月第一天和每个月的最后一天
        LocalDate firstDayOfThisMonth = now.withDayOfMonth(1).toLocalDate();
        System.out.println(firstDayOfThisMonth);
        separatorLine();

        //获取上上个月的第一天和上个月的最后一天
        LocalDate firstDayOfMonthBeforeLastMonth = now.minusMonths(2).withDayOfMonth(1).toLocalDate();
        LocalDate lastDayOfMonthBeforeLastMonth = now.withDayOfMonth(1).minusDays(1).toLocalDate();
        System.out.println(firstDayOfMonthBeforeLastMonth);
        System.out.println(lastDayOfMonthBeforeLastMonth);
        separatorLine();
    }

    public static void separatorLine(String mark) {
        System.out.println("----------分割线" + mark + "----------");
    }

    public static void separatorLine() {
        System.out.println("----------分割线----------");
    }
}

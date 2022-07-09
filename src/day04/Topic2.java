package day04;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
    2  输入你生日的前一周的周四是该年的第几天？
    Calendar:set方法设置到你的生日，
    add方法跳到前一周的周四，通过 xxxx获得是该年的第几天? get(Calendar.DAY_OF_YEAR)
    */
public class Topic2 {
    //    输入你生日的前一周的周四是该年的第几天？2000年05月21日

    public static void main(String[] args) throws ParseException {
//        周四晚上的想法
        first();
//听课改正后的想法
        second();
    }

    private static void second() {
        Calendar instance = Calendar.getInstance();
        instance.set(2022,0,11);
        instance.add(Calendar.DAY_OF_WEEK, -4);
        int day = instance.get(Calendar.DAY_OF_YEAR);
        System.out.println("我生日的前一周的周四是该年的第"+day+"天");
    }

    private static void first() throws ParseException {
        String[] weeks = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
//        格式化日期 ;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse("2000-05-21");
        Date date0 = dateFormat.parse("2000-01-01");
//生日当天和上周四的天数距离
        SimpleDateFormat weekType = new SimpleDateFormat("E");
        String week = weekType.format(date);
        int weekDiffer=0;
        for (int i = 0; i < weeks.length; i++) {
            if (weeks[i].equals(week)) {
                 weekDiffer = i+7-4;
            }
        }
//        生日和当年一月一号的的天数距离减去生日当天和上周四的天数距离
        long dayDiffer=(date.getTime()-date0.getTime())/(3600*24*1000)-weekDiffer;

        System.out.println("我生日的前一周的周四是该年的第"+dayDiffer+"天");
    }


}

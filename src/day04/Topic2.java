package day04;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*  1 使用大数运算，就算
    4444444.4444/3.333333的值，保留2位小数，四舍五入
    2  输入你生日的前一周的周四是该年的第几天？
    Calendar:set方法设置到你的生日，
    add方法跳到前一周的周四，通过 xxxx获得是该年的第几天? get(Calendar.DAY_OF_YEAR)
    3、递归输出src目录中的所有.java文件的绝对路径。
    4、在电脑D盘下创建一个文件为HelloWorld.txt文件，判断他是文件还是目录，再创建一个目录IOTest，之后将HelloWorld.txt拷贝到IOTest目录的a.txt去。
    5、从utf-8编码格式的文本复制到GBK编码的文本（不能出现乱码）*/
public class Topic2 {
    //    输入你生日的前一周的周四是该年的第几天？2000年05月21日
    static String[] weeks = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};

    public static void main(String[] args) throws ParseException {
//        Date date = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse("2000-05-21");
        Date date0 = dateFormat.parse("2000-01-01");

        SimpleDateFormat weekType = new SimpleDateFormat("E");
        String week = weekType.format(date);

        int weekDiffer = differ(week);
        System.out.println(weekDiffer);
//        System.out.println(date.getTime()-date0.getTime()-Differ);
        long dayDiffer=(date.getTime()-date0.getTime())/(3600*24*1000)-weekDiffer;

        System.out.println(dayDiffer);

    }

    static int differ(String week) {
        for (int i = 0; i < weeks.length; i++) {
            if (weeks[i].equals(week)) {
                System.out.println("i"+i);
                return i+7-4;
            }
        }
        return -1;
    }

}

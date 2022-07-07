package day04;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*  1 ʹ�ô������㣬����
    4444444.4444/3.333333��ֵ������2λС������������
    2  ���������յ�ǰһ�ܵ������Ǹ���ĵڼ��죿
    Calendar:set�������õ�������գ�
    add��������ǰһ�ܵ����ģ�ͨ�� xxxx����Ǹ���ĵڼ���? get(Calendar.DAY_OF_YEAR)
    3���ݹ����srcĿ¼�е�����.java�ļ��ľ���·����
    4���ڵ���D���´���һ���ļ�ΪHelloWorld.txt�ļ����ж������ļ�����Ŀ¼���ٴ���һ��Ŀ¼IOTest��֮��HelloWorld.txt������IOTestĿ¼��a.txtȥ��
    5����utf-8�����ʽ���ı����Ƶ�GBK������ı������ܳ������룩*/
public class Topic2 {
    //    ���������յ�ǰһ�ܵ������Ǹ���ĵڼ��죿2000��05��21��
    static String[] weeks = {"������", "����һ", "���ڶ�", "������", "������", "������", "������"};

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

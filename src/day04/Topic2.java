package day04;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
    2  ���������յ�ǰһ�ܵ������Ǹ���ĵڼ��죿
    Calendar:set�������õ�������գ�
    add��������ǰһ�ܵ����ģ�ͨ�� xxxx����Ǹ���ĵڼ���? get(Calendar.DAY_OF_YEAR)
    */
public class Topic2 {
    //    ���������յ�ǰһ�ܵ������Ǹ���ĵڼ��죿2000��05��21��

    public static void main(String[] args) throws ParseException {
//        �������ϵ��뷨
        first();
//���θ�������뷨
        second();
    }

    private static void second() {
        Calendar instance = Calendar.getInstance();
        instance.set(2022,0,11);
        instance.add(Calendar.DAY_OF_WEEK, -4);
        int day = instance.get(Calendar.DAY_OF_YEAR);
        System.out.println("�����յ�ǰһ�ܵ������Ǹ���ĵ�"+day+"��");
    }

    private static void first() throws ParseException {
        String[] weeks = {"������", "����һ", "���ڶ�", "������", "������", "������", "������"};
//        ��ʽ������ ;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse("2000-05-21");
        Date date0 = dateFormat.parse("2000-01-01");
//���յ���������ĵ���������
        SimpleDateFormat weekType = new SimpleDateFormat("E");
        String week = weekType.format(date);
        int weekDiffer=0;
        for (int i = 0; i < weeks.length; i++) {
            if (weeks[i].equals(week)) {
                 weekDiffer = i+7-4;
            }
        }
//        ���պ͵���һ��һ�ŵĵ����������ȥ���յ���������ĵ���������
        long dayDiffer=(date.getTime()-date0.getTime())/(3600*24*1000)-weekDiffer;

        System.out.println("�����յ�ǰһ�ܵ������Ǹ���ĵ�"+dayDiffer+"��");
    }


}

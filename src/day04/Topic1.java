package day04;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/*  1 ʹ�ô������㣬����
    4444444.4444/3.333333��ֵ������2λС������������
    2  ���������յ�ǰһ�ܵ������Ǹ���ĵڼ��죿
    Calendar:set�������õ�������գ�
    add��������ǰһ�ܵ����ģ�ͨ�� xxxx����Ǹ���ĵڼ���? get(Calendar.DAY_OF_YEAR)
    3���ݹ����srcĿ¼�е�����.java�ļ��ľ���·����
    4���ڵ���D���´���һ���ļ�ΪHelloWorld.txt�ļ����ж������ļ�����Ŀ¼���ٴ���һ��Ŀ¼IOTest��֮��HelloWorld.txt������IOTestĿ¼��a.txtȥ��
    5����utf-8�����ʽ���ı����Ƶ�GBK������ı������ܳ������룩*/
public class Topic1 {
    public static void main(String[] args) {
//        BigInteger a=new BigInteger("4444444");
//        BigInteger b=new BigInteger("3.333333");
        BigDecimal a = new BigDecimal("4444444.4444");
        BigDecimal b = new BigDecimal("3.333333");
        bigNum(a, b);
    }

     static void  bigNum(BigDecimal a, BigDecimal b) {
         BigDecimal num = a.multiply(b).setScale(2, RoundingMode.HALF_UP);
         System.out.println("������λС��\t"+ a.doubleValue()+"/"+b.doubleValue()+"="+num);
//         double s = (double) a.multiply(b);
    }
}

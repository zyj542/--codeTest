package day04;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/*  1 使用大数运算，就算
    4444444.4444/3.333333的值，保留2位小数，四舍五入
    */
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
         System.out.println("保留两位小数\t"+ a.doubleValue()+"/"+b.doubleValue()+"="+num);
//         double s = (double) a.multiply(b);
    }
}

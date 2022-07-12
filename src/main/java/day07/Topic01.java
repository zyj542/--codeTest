package day07;

import lombok.Data;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;
//����:@Dataע��ʧЧ
//@Data
@Data
class Book {
    private int bid;
    private String name;
    private float price;



    public Book(int bid, String name, float price) {
        this.bid = bid;
        this.name = name;
        this.price = price;
    }

    public void sell() {
        System.out.println("���鱻����");
    }

    private void sell(float price, String person) {
        System.out.printf("����������"+person+"������"+ price+"Ԫ");
    }
}
/*������Book:int bid,String name,float price
        ���� ȫ���������⣬������ public void sell(){ //��ʾ���鱻����}
private  void sell(float price,String person)://��ʾ����������xxx������ xxxԪ
        ͨ������ʵ�֣�
        1 ��ȡBook����Ϣ������ȡȫ���Թ��캯������constructor

        2 ���øù�����󣬴���1�����ʵ����

        3 ͨ�����䣬�ֱ��ȡ����sell������Ӧ��method����
        ���ƻ���װ�ԣ��ֱ���ø÷�����*/
public class Topic01 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        ��ȡBook����Ϣ();
//        new Book(1, "s", 1f);
    }

    private static void ��ȡBook����Ϣ() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
//        1 ��ȡBook����Ϣ������ȡȫ���Թ��캯������constructor
        Class c = Book.class;
        Constructor con = c.getConstructor(int.class,String.class,float.class);
//        Constructor con = c.getConstructor(int.class,float.class,String.class);
//        Constructor con = c.getConstructor(String.class,int.class,float.class);
//        Constructor con = c.getConstructor(String.class,float.class,int.class);
//        Constructor con = c.getConstructor(float.class,String.class,int.class);
//        Constructor con = c.getConstructor(float.class,int.class,String.class);
//        System.out.print(con);
//        2 ���øù�����󣬴���1�����ʵ����
        Book c1 = (Book) con.newInstance(1,"a",2f);

//        3 ͨ�����䣬�ֱ��ȡ����sell������Ӧ��method���󣬲��ƻ���װ�ԣ��ֱ���ø÷���
        Method sell = c.getDeclaredMethod("sell");
        sell.setAccessible(true);
        sell.invoke(c1);
        Method sell1 = c.getDeclaredMethod("sell", float.class, String.class);
        sell1.setAccessible(true);
        sell1.invoke(c1, 1f, "a");




    }
}

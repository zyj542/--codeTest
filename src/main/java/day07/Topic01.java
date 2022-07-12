package day07;

import lombok.Data;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;
//问题:@Data注释失效
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
        System.out.println("本书被卖了");
    }

    private void sell(float price, String person) {
        System.out.printf("本书卖给了"+person+"，卖了"+ price+"元");
    }
}
/*定义类Book:int bid,String name,float price
        除了 全参数构造外，还包含 public void sell(){ //显示本书被卖了}
private  void sell(float price,String person)://显示本书卖给了xxx，卖了 xxx元
        通过反射实现：
        1 获取Book类信息，并获取全属性构造函数对象constructor

        2 利用该构造对象，创建1个书的实例。

        3 通过反射，分别获取两个sell方法对应的method对象，
        并破坏封装性，分别调用该方法。*/
public class Topic01 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        获取Book类信息();
//        new Book(1, "s", 1f);
    }

    private static void 获取Book类信息() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
//        1 获取Book类信息，并获取全属性构造函数对象constructor
        Class c = Book.class;
        Constructor con = c.getConstructor(int.class,String.class,float.class);
//        Constructor con = c.getConstructor(int.class,float.class,String.class);
//        Constructor con = c.getConstructor(String.class,int.class,float.class);
//        Constructor con = c.getConstructor(String.class,float.class,int.class);
//        Constructor con = c.getConstructor(float.class,String.class,int.class);
//        Constructor con = c.getConstructor(float.class,int.class,String.class);
//        System.out.print(con);
//        2 利用该构造对象，创建1个书的实例。
        Book c1 = (Book) con.newInstance(1,"a",2f);

//        3 通过反射，分别获取两个sell方法对应的method对象，并破坏封装性，分别调用该方法
        Method sell = c.getDeclaredMethod("sell");
        sell.setAccessible(true);
        sell.invoke(c1);
        Method sell1 = c.getDeclaredMethod("sell", float.class, String.class);
        sell1.setAccessible(true);
        sell1.invoke(c1, 1f, "a");




    }
}

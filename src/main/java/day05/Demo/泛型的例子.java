package day05.Demo;

/**
 * @ClassName 泛型的例子
 * @Description TODO
 * @Author HP
 * @Date 10:47 2022/7/8
 * @Version 1.0
 **/
class P{  //父类对象

}
class C extends  P{ //子类对象
   public void testInC(){
       System.out.println("testInC");
   }
}
//不使用泛型
class A{
    //private C p;//关联 。依赖于具体！！！！！不利于代码维护
    private P p;
    public A(P p) {
        this.p = p;
    }
    public void test(){
        //需要把父类对象向下转型成子类对象来做
        C c = (C) p; //运行期可能出故障
        c.testInC();
    }
}
//使用泛型
class B<T extends  C>{  //指定上界为C类的泛型参数
    private T t;
    public B(T t) {
        this.t = t;
    }
    public void test(){
        //需要把父类对象向下转型成子类对象来做
       t.testInC(); //无需向下转型
    }

}
public class 泛型的例子 {
    public static void main(String[] args) {
        A a = new A(new C());
        a.test();; //编译期没有报错，但是运行期报错。代码的安全性比较差。
        //B b = new B(new P()); //将错误由运行期，提早到编译期，代码更安全。
        B b = new B(new C());
        b.test();
    }
}

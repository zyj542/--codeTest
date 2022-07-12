package day05.Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @ClassName 泛型类和泛型方法
 * @Description TODO
 * @Author HP
 * @Date 11:12 2022/7/8
 * @Version 1.0
 **/
//带1个泛型参数的泛型类
class M<T>{
    private T t;
    private T[] ts;
    private List<T> list = new ArrayList<>();
    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public T[] getTs() {
        return ts;
    }

    public void setTs(T[] ts) {
        this.ts = ts;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }


    //将泛型类对象作为入参，调用方法
    public void add(T t){
        this.t = t;
        this.ts[0] = t;
        list.add(t);
        System.out.println("添加成功！");
    }
}
//带两个个泛型参数的泛型类
class N<K1,K2>{
//    private K1 k1;
//    private K2 k2;
    //将泛型类对象作为入参，调用方法
    public boolean compareHashCode(K1 k1,K2 k2 ){
       if(k1!=null&&k2!=null) {
           return k1.hashCode()>k2.hashCode();
       }
       return false;
    }
}

class Parent{

}
class Child extends Parent{

}
class X{
    //提供工具类方法，将第二个集合的元素，全部添加到第1个集合中
    //泛型方法。指定上界。 ?称为泛型通配符。
    public static <T> void add1(Collection<T> collection1, Collection<? extends T> collection2){
        for(T t:collection2){
            collection1.add(t);//将父类的元素，拿出来依次添加到子类中
        }
        System.out.println("添加成功！size="+collection1.size());
    }
    //泛型方法。指定下界。 ?称为泛型通配符。
    public static <T> void add2(Collection< ? super T> collection1, Collection<T> collection2){
        for(T t:collection2){
            collection1.add(t);//将父类的元素，拿出来依次添加到子类中
        }
        System.out.println("添加成功！");
    }
}
class 泛型类和泛型方法 {
    public static void main(String[] args) {
        //1 使用1个入参的泛型类
        M<String> m1 = new M<>(); //指定泛型参数为String类
        m1.setT("aaaa");
        m1.setTs(new String[]{"aa","bb"});
        m1.setList(new ArrayList<>());
        m1.add("bbb");

        //2 使用两个入参的泛型类
        N<String,Integer> n1 = new N<>();
        System.out.println(n1.compareHashCode("aaa",123));

        //3 测试泛型方法
        Parent ps[] = {new Parent(),new Parent()};
        //Parent cs[] = {new Child(),new Child()};
        List<Parent> list1 = new ArrayList<>(); //可读可写
        list1.addAll(Arrays.asList(new Parent(),new Parent()));
        //Arrays.asList//将数组转成动态数组。只读不可写。  //装饰者模式。本质上还是静态数组
        X.add1( list1,Arrays.asList(new Child(),new Child()));
        X.add2(list1,Arrays.asList(new Child(),new Child()));
        //牛逼的工程师，前辈，写的代码大多包含泛型。
    }
}

package day05.Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName ArrayList的例子
 * @Description TODO
 * @Author HP
 * @Date 11:51 2022/7/8
 * @Version 1.0
 **/
class Y{
    private int x;

    public Y(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "Y{" +
                "x=" + x +
                '}';
    }
}
public class ArrayList的例子 {

    public static void main(String[] args) {
        //常用方法();
        //数组和ArrayList的相互转换();
        //小练习();
        四种遍历方法();
    }

    private static void 四种遍历方法() {
        List<String> list = Arrays.asList("aaa","bbb","cccc","dddd");
        //1 标准for循环
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();

        //2 增强for循环.本质上就是迭代器。
        for (String str:list){
            System.out.print(str+" ");
        }
        System.out.println();
        //3 使用迭代器
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String str = it.next();//走到下一个元素，返回该元素对象
            System.out.print(str+" ");
        }
        System.out.println();
        //4 stream函数。不同于IO流。 jdk1.8的新特性。流式方法可以看成是对集合框架的另一种视图展现。
        //list.stream().forEach((String e)->{System.out.print(e+" ");});
        //list.stream().forEach(e->System.out.print(e+" "));
        //进一步简化为
        list.stream().forEach(System.out::println);  //如果左边的参数和右边的代码参数相同，允许省略
        System.out.println();

        //遍历自定义类型动态数组
        List<Y> list2 = Arrays.asList(new Y(10),new Y(20));
        for(Y y:list2){
            System.out.println(y);
        }
        System.out.println("-----------------");
        //迭代器
        Iterator<Y> it2 = list2.iterator();
        while(it2.hasNext()){
            System.out.println(it2.next());
        }
        System.out.println("-----------------");
        list2.stream().forEach(System.out::println);
    }

    private static void 小练习() {
        List<Float> list = new ArrayList<>();
        list.add(1.0f);
        list.add(2.0f);
        list.add(3.0f);
        int index = list.indexOf(2.0f);
        System.out.println(index);
        if(index>=0)
            list.set(index,6.0f);
        System.out.println("修改后:"+list);
        list.remove(list.size()-1);
        System.out.println(list.size());
    }

    private static void 数组和ArrayList的相互转换() {
        Integer a[] = {1,2,3};
        List<Integer> list = Arrays.asList(a); //将数组转成List，
        list.set(2,1000);
        //list.add(3);//报错。注意：长度无法发生改变。
        System.out.println(list.get(2)+"  "+ a[2]);

        Integer a2[] = new Integer[3];
        list.toArray(a2) ;//将ArrayList转成普通数组
        System.out.println(a2[2]);
    }
    //小练习：创建数组 ArrayList<Float> list
    private static void 常用方法() {
        ArrayList<String> list = new ArrayList<>(20); //构造方法.默认初始容量10。
        list.add("aaa");//添加到末尾！
        list.add("bbb");
        list.add(0,"ccc");
        String str = list.get(2);//获得第2号元素。相当于数组的a[2].
        list.set(2,"xxxxx");//修改第2号元素的值，相当 a[2] = "xxxxxx";'
        System.out.println(str);
        System.out.println(list.toString());  //可以直接输出
        int index = list.indexOf("bbb");//查找元素的序号。找不到返回-1
        System.out.println(list.size());//大小
        System.out.println("index");
        list.remove("bbb");//指定元素删除
        list.remove(1);//指定序号删除
        list.clear();
        System.out.println(list.isEmpty());
        System.out.println(list.contains("ccc"));//是否包含某个元素

        //2 其他构造方法
        List<Integer> list2  = Arrays.asList(1,2,3,4,5);  //快速构造
        ArrayList<String> list3 = new ArrayList<>(list);//复制构造。
        list3.addAll(list);//将list的数组的所有元素，添加到本元素末尾。
    }
}

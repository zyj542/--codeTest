package day05.Demo;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @ClassName HashSet的例子
 * @Description TODO
 * @Author HP
 * @Date 16:29 2022/7/8
 * @Version 1.0
 **/
public class HashSet的例子 {
    public static void main(String[] args) {
        //HashSet常用方法();
        HashSet的遍历();
    }

    private static void HashSet的遍历() {
            //1 使用增强for遍历
            HashSet<String> set = new HashSet<>();
            set.add("aaaa");//添加元素
            set.add("cccc");//添加元素
            set.add("bbbb");//添加元素
            set.add("dddd");//添加元素
            set.add("eeee");//添加元素
            for(String str:set){
                System.out.print(str+" ");
            }
            System.out.println();
            //2 使用迭代器遍历
            Iterator<String> it = set.iterator();
            while(it.hasNext()){
                System.out.print(it.next()+" ");
            }

        System.out.println("--------------------");
            //3 使用流遍历
            set.stream().forEach(System.out::print);
        System.out.println("--------------------");
            HashSet<Integer> set2 = new HashSet<>();
            set2.add(100);
            set2.add(50);
            set2.add(400);
            set2.stream().forEach(System.out::println);

    }

    private static void HashSet常用方法() {
        HashSet<String> set = new HashSet<>();
        set.add("aaaa");//添加元素
        System.out.println(set.add("bbbb"));//添加元素，不重复.
        System.out.println(set.add("aaaa"));//重复元素.不进入set。
        System.out.println(set.size());
        //set.get(i);//无法按照序号读取
        //指定元素进行删除
        set.remove("aaaa");
    }
}

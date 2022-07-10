package day05.Demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Vector;

/**
 * @ClassName LinkedList和Vector
 * @Description TODO
 * @Author HP
 * @Date 15:07 2022/7/8
 * @Version 1.0
 **/
public class LinkedList和Vector {
    public static void main(String[] args) {
        链表常用用法();
        测试链表和数组的添加元素速度();
        向量常用用法();
    }

    private static void 向量常用用法() {
        Vector<String> v = new Vector<>();
        v.add("aaa");
        System.out.println(v.size());
    }

    private static void 测试链表和数组的添加元素速度() {
        ArrayList<Integer> list1= new ArrayList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        long begin = new Date().getTime();
        for(int i=0;i<100000;i++){
            list1.add(0,i);
        }
        long end = new Date().getTime();
        System.out.println("ArrayList耗时:"+(end-begin)+"毫秒");

        begin = new Date().getTime();
        for(int i=0;i<100000;i++){
            list2.add(0,i);
        }
        end = new Date().getTime();
        System.out.println("LinkedList耗时:"+(end-begin)+"毫秒");
    }

    private static void 链表常用用法() {
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("aaa"); //从头部添加
        list.addLast("bbbb"); //从尾部添加
        list.push("cccc");  //压入到最底部元素   //模拟堆栈
        list.pop();//弹出最底部元素
        System.out.println(list);
    }
}

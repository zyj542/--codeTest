package day05.Demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Vector;

/**
 * @ClassName LinkedList��Vector
 * @Description TODO
 * @Author HP
 * @Date 15:07 2022/7/8
 * @Version 1.0
 **/
public class LinkedList��Vector {
    public static void main(String[] args) {
        �������÷�();
        �����������������Ԫ���ٶ�();
        ���������÷�();
    }

    private static void ���������÷�() {
        Vector<String> v = new Vector<>();
        v.add("aaa");
        System.out.println(v.size());
    }

    private static void �����������������Ԫ���ٶ�() {
        ArrayList<Integer> list1= new ArrayList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        long begin = new Date().getTime();
        for(int i=0;i<100000;i++){
            list1.add(0,i);
        }
        long end = new Date().getTime();
        System.out.println("ArrayList��ʱ:"+(end-begin)+"����");

        begin = new Date().getTime();
        for(int i=0;i<100000;i++){
            list2.add(0,i);
        }
        end = new Date().getTime();
        System.out.println("LinkedList��ʱ:"+(end-begin)+"����");
    }

    private static void �������÷�() {
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("aaa"); //��ͷ�����
        list.addLast("bbbb"); //��β�����
        list.push("cccc");  //ѹ�뵽��ײ�Ԫ��   //ģ���ջ
        list.pop();//������ײ�Ԫ��
        System.out.println(list);
    }
}

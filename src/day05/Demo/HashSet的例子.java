package day05.Demo;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @ClassName HashSet������
 * @Description TODO
 * @Author HP
 * @Date 16:29 2022/7/8
 * @Version 1.0
 **/
public class HashSet������ {
    public static void main(String[] args) {
        //HashSet���÷���();
        HashSet�ı���();
    }

    private static void HashSet�ı���() {
            //1 ʹ����ǿfor����
            HashSet<String> set = new HashSet<>();
            set.add("aaaa");//���Ԫ��
            set.add("cccc");//���Ԫ��
            set.add("bbbb");//���Ԫ��
            set.add("dddd");//���Ԫ��
            set.add("eeee");//���Ԫ��
            for(String str:set){
                System.out.print(str+" ");
            }
            System.out.println();
            //2 ʹ�õ���������
            Iterator<String> it = set.iterator();
            while(it.hasNext()){
                System.out.print(it.next()+" ");
            }

        System.out.println("--------------------");
            //3 ʹ��������
            set.stream().forEach(System.out::print);
        System.out.println("--------------------");
            HashSet<Integer> set2 = new HashSet<>();
            set2.add(100);
            set2.add(50);
            set2.add(400);
            set2.stream().forEach(System.out::println);

    }

    private static void HashSet���÷���() {
        HashSet<String> set = new HashSet<>();
        set.add("aaaa");//���Ԫ��
        System.out.println(set.add("bbbb"));//���Ԫ�أ����ظ�.
        System.out.println(set.add("aaaa"));//�ظ�Ԫ��.������set��
        System.out.println(set.size());
        //set.get(i);//�޷�������Ŷ�ȡ
        //ָ��Ԫ�ؽ���ɾ��
        set.remove("aaaa");
    }
}

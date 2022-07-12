package day05.Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName ArrayList������
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
public class ArrayList������ {

    public static void main(String[] args) {
        //���÷���();
        //�����ArrayList���໥ת��();
        //С��ϰ();
        ���ֱ�������();
    }

    private static void ���ֱ�������() {
        List<String> list = Arrays.asList("aaa","bbb","cccc","dddd");
        //1 ��׼forѭ��
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();

        //2 ��ǿforѭ��.�����Ͼ��ǵ�������
        for (String str:list){
            System.out.print(str+" ");
        }
        System.out.println();
        //3 ʹ�õ�����
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String str = it.next();//�ߵ���һ��Ԫ�أ����ظ�Ԫ�ض���
            System.out.print(str+" ");
        }
        System.out.println();
        //4 stream��������ͬ��IO���� jdk1.8�������ԡ���ʽ�������Կ����ǶԼ��Ͽ�ܵ���һ����ͼչ�֡�
        //list.stream().forEach((String e)->{System.out.print(e+" ");});
        //list.stream().forEach(e->System.out.print(e+" "));
        //��һ����Ϊ
        list.stream().forEach(System.out::println);  //�����ߵĲ������ұߵĴ��������ͬ������ʡ��
        System.out.println();

        //�����Զ������Ͷ�̬����
        List<Y> list2 = Arrays.asList(new Y(10),new Y(20));
        for(Y y:list2){
            System.out.println(y);
        }
        System.out.println("-----------------");
        //������
        Iterator<Y> it2 = list2.iterator();
        while(it2.hasNext()){
            System.out.println(it2.next());
        }
        System.out.println("-----------------");
        list2.stream().forEach(System.out::println);
    }

    private static void С��ϰ() {
        List<Float> list = new ArrayList<>();
        list.add(1.0f);
        list.add(2.0f);
        list.add(3.0f);
        int index = list.indexOf(2.0f);
        System.out.println(index);
        if(index>=0)
            list.set(index,6.0f);
        System.out.println("�޸ĺ�:"+list);
        list.remove(list.size()-1);
        System.out.println(list.size());
    }

    private static void �����ArrayList���໥ת��() {
        Integer a[] = {1,2,3};
        List<Integer> list = Arrays.asList(a); //������ת��List��
        list.set(2,1000);
        //list.add(3);//����ע�⣺�����޷������ı䡣
        System.out.println(list.get(2)+"  "+ a[2]);

        Integer a2[] = new Integer[3];
        list.toArray(a2) ;//��ArrayListת����ͨ����
        System.out.println(a2[2]);
    }
    //С��ϰ���������� ArrayList<Float> list
    private static void ���÷���() {
        ArrayList<String> list = new ArrayList<>(20); //���췽��.Ĭ�ϳ�ʼ����10��
        list.add("aaa");//��ӵ�ĩβ��
        list.add("bbb");
        list.add(0,"ccc");
        String str = list.get(2);//��õ�2��Ԫ�ء��൱�������a[2].
        list.set(2,"xxxxx");//�޸ĵ�2��Ԫ�ص�ֵ���൱ a[2] = "xxxxxx";'
        System.out.println(str);
        System.out.println(list.toString());  //����ֱ�����
        int index = list.indexOf("bbb");//����Ԫ�ص���š��Ҳ�������-1
        System.out.println(list.size());//��С
        System.out.println("index");
        list.remove("bbb");//ָ��Ԫ��ɾ��
        list.remove(1);//ָ�����ɾ��
        list.clear();
        System.out.println(list.isEmpty());
        System.out.println(list.contains("ccc"));//�Ƿ����ĳ��Ԫ��

        //2 �������췽��
        List<Integer> list2  = Arrays.asList(1,2,3,4,5);  //���ٹ���
        ArrayList<String> list3 = new ArrayList<>(list);//���ƹ��졣
        list3.addAll(list);//��list�����������Ԫ�أ���ӵ���Ԫ��ĩβ��
    }
}

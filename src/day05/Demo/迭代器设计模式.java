package day05.Demo;

import java.util.Iterator;

import java.util.function.Consumer;

/**
 * @ClassName ���������ģʽ
 * @Description TODO
 * @Author HP
 * @Date 15:27 2022/7/8
 * @Version 1.0
 **/
class �������� implements  Iterable<String> {  //ʵ�ֿɵ����ӿ�
    private String str1 = "������";  //��1���ַ���
    private String str2 = "����ɽ";  //��2���ַ���
    private String str3 = "����"; //��3���ַ���
    private int index = 0;
    private Iterator<String> it = new Iterator<String>() {
        @Override
        public boolean hasNext() {  //��û����һ��
            if (index < 3) //�ܹ�ֻ��3���ַ������Ա���
                return true;
            return false;
        }

        @Override
        public String next() {  //��һ����˭
            if (index == 0) {
                index++;
                return str1;
            }
            if (index == 1) {
                index++;
                return str2;
            }
            if (index == 2) {
                index++;
                return str3;
            }
            return null;
        }
    }; //ӵ��һ��������

    @Override
    public Iterator<String> iterator() {
        return it;
    }
}

public class ���������ģʽ {
    public static void main(String[] args) {
        �������� m = new ��������();
        //ֻҪʵ�ֵ�����ģʽ������ʹ����ǿforѭ��
        for(String str:m){
            System.out.println(str);
        }
        System.out.println("----------------------");
        //ֱ��ʹ�õ��������б���
        �������� m2 = new ��������();
        Iterator<String> it = m2.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}

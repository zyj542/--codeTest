package day05.Demo;

/**
 * @ClassName ���͵�����
 * @Description TODO
 * @Author HP
 * @Date 10:47 2022/7/8
 * @Version 1.0
 **/
class P{  //�������

}
class C extends  P{ //�������
   public void testInC(){
       System.out.println("testInC");
   }
}
//��ʹ�÷���
class A{
    //private C p;//���� �������ھ��壡�������������ڴ���ά��
    private P p;
    public A(P p) {
        this.p = p;
    }
    public void test(){
        //��Ҫ�Ѹ����������ת�ͳ������������
        C c = (C) p; //�����ڿ��ܳ�����
        c.testInC();
    }
}
//ʹ�÷���
class B<T extends  C>{  //ָ���Ͻ�ΪC��ķ��Ͳ���
    private T t;
    public B(T t) {
        this.t = t;
    }
    public void test(){
        //��Ҫ�Ѹ����������ת�ͳ������������
       t.testInC(); //��������ת��
    }

}
public class ���͵����� {
    public static void main(String[] args) {
        A a = new A(new C());
        a.test();; //������û�б������������ڱ�������İ�ȫ�ԱȽϲ
        //B b = new B(new P()); //�������������ڣ����絽�����ڣ��������ȫ��
        B b = new B(new C());
        b.test();
    }
}

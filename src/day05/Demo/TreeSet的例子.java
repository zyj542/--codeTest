package day05.Demo;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @ClassName TreeSet������
 * @Description TODO
 * @Author HP
 * @Date 17:10 2022/7/8
 * @Version 1.0
 **/
//����1�����Զ�����ʵ�ֿɱȽϽӿ�
class Student implements  Comparable<Student>{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override  //ʵ�ֱȽϹ���
    public int compareTo(Student o) {
        //���ظ�����˵������������ǰ�档����0����������������ȣ�Ԫ�ر��ж�Ϊ�ظ����޷�����set�С�
        //����������˵�����������ں���
        if (this.age<o.age) {
            return -1;
        }//ֻҪ�ȽϷ���������0���������ظ�
        return 1;
    }
}
//�Զ���Ƚ���ʵ�ְ����ֵĳ�������
class MyStudentCompartor implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getName().length()<o2.getName().length()) {
            return -1;
        }
        return 1;
    }
}
public class TreeSet������ {
    public static void main(String[] args) {
        //���÷���();
        �Զ���ȽϹ���();

    }

    private static void �Զ���ȽϹ���() {
        //TreeSet<Student>  set = new TreeSet<>();
        TreeSet<Student>  set = new TreeSet<>(new MyStudentCompartor()); //�����Զ���Ƚ�����ʵ�ְ����ֳ�������
        set.add(new Student("aa",18));
        set.add(new Student("abrrrrc",21));
        set.add(new Student("zzz",21));
        set.stream().forEach(System.out::println);
    }

    private static void ���÷���() {
        TreeSet<Integer> set = new TreeSet<>(); //Ĭ��������򣬴����ֵ�С����
        set.add(100);
        set.add(10);
        set.add(200);
        set.stream().forEach(System.out::println);
        System.out.println("--------------------");
        TreeSet<String> set2 = new TreeSet<>(); //Ĭ��������򣬰����ֵ�˳��
        set2.add("aa");
        set2.add("abb");
        set2.add("z");
        set2.stream().forEach(System.out::println);
    }
}

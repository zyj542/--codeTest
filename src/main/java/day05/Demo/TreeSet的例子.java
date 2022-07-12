package day05.Demo;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @ClassName TreeSet的例子
 * @Description TODO
 * @Author HP
 * @Date 17:10 2022/7/8
 * @Version 1.0
 **/
//方法1，让自定义类实现可比较接口
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

    @Override  //实现比较规则
    public int compareTo(Student o) {
        //返回负数，说明本对象排在前面。返回0，代表两个对象相等，元素被判定为重复，无法进入set中。
        //返回正数，说明本对象排在后面
        if (this.age<o.age) {
            return -1;
        }//只要比较方法不返回0，就允许重复
        return 1;
    }
}
//自定义比较器实现按名字的长度排序
class MyStudentCompartor implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getName().length()<o2.getName().length()) {
            return -1;
        }
        return 1;
    }
}
public class TreeSet的例子 {
    public static void main(String[] args) {
        //常用方法();
        自定义比较规则();

    }

    private static void 自定义比较规则() {
        //TreeSet<Student>  set = new TreeSet<>();
        TreeSet<Student>  set = new TreeSet<>(new MyStudentCompartor()); //传入自定义比较器，实现按名字长度排序
        set.add(new Student("aa",18));
        set.add(new Student("abrrrrc",21));
        set.add(new Student("zzz",21));
        set.stream().forEach(System.out::println);
    }

    private static void 常用方法() {
        TreeSet<Integer> set = new TreeSet<>(); //默认排序规则，从数字的小到大。
        set.add(100);
        set.add(10);
        set.add(200);
        set.stream().forEach(System.out::println);
        System.out.println("--------------------");
        TreeSet<String> set2 = new TreeSet<>(); //默认排序规则，按“字典顺序”
        set2.add("aa");
        set2.add("abb");
        set2.add("z");
        set2.stream().forEach(System.out::println);
    }
}

package day05;

import java.util.ArrayList;
import java.util.Scanner;

/*2 创建类 Student：
        int sid(学号)
        String name(姓名) ,
        int age;
要求使用两种方法实现自定义比较规则： 先按学号排，如果学号学号重复，按年龄排。
并遍历输出结果*/
class Student {
    private final int sid;
    private final int age;
    private final String name;

    public Student(int sid, int age, String name) {
        this.sid = sid;
        this.age = age;
        this.name = name;
    }

    public int getSid() {
        return sid;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

public class Topic02 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        Student[] stuArr = setStudents(sc);//键盘输入的方法
        Student[] stuArr = new Student[3];
        stuArr[0] = new Student(193, 20, "张三");
        stuArr[1] = new Student(193, 18, "李四");
        stuArr[2] = new Student(192, 30, "王五");

        planA(stuArr);
        planB(stuArr);
    }

    //    从大到小 排序冒泡
    private static void planA(Student[] stuArr) {
        for (int i = 0; i < stuArr.length - 1; i++) {

            Student stuTemp = new Student(0, 0, null);
            for (int j = i; j < stuArr.length - 1; j++) {

                if (stuTemp.getSid() > stuArr[i].getSid()) {
                    stuTemp = stuArr[j];
                    stuArr[j] = stuArr[i];
                    stuArr[i] = stuTemp;
                } else if (stuTemp.getSid() == stuArr[i].getSid() && stuTemp.getAge() > stuArr[i].getAge()) {
                    stuTemp = stuArr[j];
                    stuArr[j] = stuArr[i];
                    stuArr[i] = stuTemp;
                }
            }
        }
        for (Student s:stuArr
             ) {
            System.out.println(s);

        }
    }

    //    从小到大排序 插入排序
    private static void planB(Student[] stuArr) {

    }

    private static Student[] setStudents(Scanner sc) {
        int temp = 0;
        System.out.print("输入学生数量");
        int num = sc.nextInt();
        Student[] stuArr = new Student[num];
        try {
            while (num-- != 0) {
                System.out.println("请输入学号,年龄,姓名");
                int id = sc.nextInt();
                int age = sc.nextInt();
                String name = sc.next();
                stuArr[temp++] = new Student(id, age, name);
            }
        } catch (Exception e) {
            System.out.println("输入格式错误");
        }
        return stuArr;
    }


}

package day05;

import java.lang.reflect.Array;
import java.util.*;

/*2 创建类 Student：
        int sid(学号)
        String name(姓名) ,
        int age;
要求使用两种方法实现自定义比较规则： 先按学号排，如果学号学号重复，按年龄排。
并遍历输出结果*/
class Student implements Comparable<Student> {
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

    @Override
    public int compareTo(Student o) {
        if (this.getSid() == o.getSid()) {
            return this.getAge() - o.getAge();
        } else return Integer.compare(this.getSid(), o.getSid());
    }
}

public class Topic02 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        Student[] stuArr = setStudents(sc);//键盘输入的方法
        Student[] stuArr = new Student[6];
        stuArr[0] = new Student(190, 20, "张三");
        stuArr[1] = new Student(193, 18, "李四");
        stuArr[2] = new Student(192, 30, "王五");
        stuArr[3] = new Student(191, 16, "赵六");
        stuArr[4] = new Student(191, 88, "孙七");
        stuArr[5] = new Student(1, 66, "周八");
        Student[] clone = stuArr.clone();
        planA(stuArr);//从大到小排序,冒泡算法
        System.out.println("--------------------------");
        planB(clone);//   重写compareTo,从小到大排序
    }

    //    从大到小 排序冒泡
    private static void planA(Student[] stuArr) {
        for (int i = 0; i < stuArr.length; i++) {

            Student stuTempMax = new Student(0, 0, null);
            for (int j = i; j < stuArr.length; j++) {

                if (stuTempMax.getSid() < stuArr[j].getSid()) {
                    stuTempMax = stuArr[j];
                    stuArr[j] = stuArr[i];
                    stuArr[i] = stuTempMax;
                } else if (stuTempMax.getSid() == stuArr[j].getSid() && stuTempMax.getAge() < stuArr[j].getAge()) {
                    stuTempMax = stuArr[j];
                    stuArr[j] = stuArr[i];
                    stuArr[i] = stuTempMax;
                }
            }
        }
        for (Student s:stuArr
             ) {
            System.out.println("学号:"+s.getSid()+"\t\t年龄:"+s.getAge()+"\t\t名字:"+s.getName());

        }
    }

    //   重写compareTo,从小到大排序
    private static void planB(Student[] stuArr) {
        ArrayList<Student> students = new ArrayList<>(Arrays.asList(stuArr));
        Collections.sort(students);
        for (Student s : students
        ) {
            System.out.println("学号:"+s.getSid()+"\t\t年龄:"+s.getAge()+"\t\t名字:"+s.getName());
        }

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

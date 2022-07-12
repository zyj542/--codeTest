package day05;

import java.lang.reflect.Array;
import java.util.*;

/*2 ������ Student��
        int sid(ѧ��)
        String name(����) ,
        int age;
Ҫ��ʹ�����ַ���ʵ���Զ���ȽϹ��� �Ȱ�ѧ���ţ����ѧ��ѧ���ظ����������š�
������������*/
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
//        Student[] stuArr = setStudents(sc);//��������ķ���
        Student[] stuArr = new Student[6];
        stuArr[0] = new Student(190, 20, "����");
        stuArr[1] = new Student(193, 18, "����");
        stuArr[2] = new Student(192, 30, "����");
        stuArr[3] = new Student(191, 16, "����");
        stuArr[4] = new Student(191, 88, "����");
        stuArr[5] = new Student(1, 66, "�ܰ�");
        Student[] clone = stuArr.clone();
        planA(stuArr);//�Ӵ�С����,ð���㷨
        System.out.println("--------------------------");
        planB(clone);//   ��дcompareTo,��С��������
    }

    //    �Ӵ�С ����ð��
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
            System.out.println("ѧ��:"+s.getSid()+"\t\t����:"+s.getAge()+"\t\t����:"+s.getName());

        }
    }

    //   ��дcompareTo,��С��������
    private static void planB(Student[] stuArr) {
        ArrayList<Student> students = new ArrayList<>(Arrays.asList(stuArr));
        Collections.sort(students);
        for (Student s : students
        ) {
            System.out.println("ѧ��:"+s.getSid()+"\t\t����:"+s.getAge()+"\t\t����:"+s.getName());
        }

    }

    private static Student[] setStudents(Scanner sc) {
        int temp = 0;
        System.out.print("����ѧ������");
        int num = sc.nextInt();
        Student[] stuArr = new Student[num];
        try {
            while (num-- != 0) {
                System.out.println("������ѧ��,����,����");
                int id = sc.nextInt();
                int age = sc.nextInt();
                String name = sc.next();
                stuArr[temp++] = new Student(id, age, name);
            }
        } catch (Exception e) {
            System.out.println("�����ʽ����");
        }
        return stuArr;
    }



}

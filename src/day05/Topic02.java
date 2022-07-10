package day05;

import java.util.ArrayList;
import java.util.Scanner;

/*2 ������ Student��
        int sid(ѧ��)
        String name(����) ,
        int age;
Ҫ��ʹ�����ַ���ʵ���Զ���ȽϹ��� �Ȱ�ѧ���ţ����ѧ��ѧ���ظ����������š�
������������*/
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
//        Student[] stuArr = setStudents(sc);//��������ķ���
        Student[] stuArr = new Student[3];
        stuArr[0] = new Student(193, 20, "����");
        stuArr[1] = new Student(193, 18, "����");
        stuArr[2] = new Student(192, 30, "����");

        planA(stuArr);
        planB(stuArr);
    }

    //    �Ӵ�С ����ð��
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

    //    ��С�������� ��������
    private static void planB(Student[] stuArr) {

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

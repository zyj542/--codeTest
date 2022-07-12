package day03;

import java.util.Scanner;

class Person {
    private String name;
    private int sex;
    private int age;
    private Boolean isMarried;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean getMarried() {
        return isMarried;
    }

    public void setMarried(Boolean married) {
        isMarried = married;
    }

    public Person(String name, int sex, int age, Boolean isMarried) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.isMarried = isMarried;
    }
    public static boolean marryWith(Person p1, Person p2) {
        //1.��Ҫδ��
        //2.Ҫ����
        //3.��������20��,Ů������19��
        return (!p1.isMarried && !p2.isMarried)
                &&( p1.sex != p2.sex)
                && (p1.sex == 1 ? p1.age >= 20 : p1.age >= 19 && p2.sex == 1 ? p2.age >=20 : p2.age >=19);
    }
    void study(String school) {
        System.out.println(this.name+"��"+school+"ѧУѧϰ");
    }
}
public class Homework {
    public static void main(String[] args) {
//        Person p1 = new Person("����", 1, 20, false) {
        Person p1 = null;
        Person p2 = null;
        try {
            p1 = new Person("����", 1, 20, false) {
                @Override
                void study(String school) {
//                Scanner scanner = new Scanner(System.in);
//                System.out.print("������ѧϰʱ��");
//                int time = scanner.nextInt();
                    int time = 4;
                    System.out.println(getName() + "��" + school + "ѧУѧϰ��" + time + "��");
                }
            };
            p2 = new Person("����", 0, 20, false) {
                @Override
                void study(String school) {
//                Scanner scanner = new Scanner(System.in);
//                System.out.print("������ѧϰʱ��");
//                int time = scanner.nextInt();
                    int time = 4;
                    System.out.println(getName() + "��" + school + "ѧУѧϰ��" + time + "��");
                }
            };
        } catch (Exception e) {
            e.printStackTrace();
        }

        p1.study("����ѧԺ");
        p2.study("������Ϣ����ѧԺ");

        if (Person.marryWith(p1, p2)) {
            System.out.println("���﷨�����䣬���Խ��");
        } else {
            System.out.println("δ�﷨�����䣬�����Խ��");

        }

    }
}

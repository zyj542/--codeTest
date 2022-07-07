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
        //1.都要未婚
        //2.要异性
        //3.男生到达20岁,女生到达19岁
        return (!p1.isMarried && !p2.isMarried)
                &&( p1.sex != p2.sex)
                && (p1.sex == 1 ? p1.age >= 20 : p1.age >= 19 && p2.sex == 1 ? p2.age >=20 : p2.age >=19);
    }
    void study(String school) {
        System.out.println(this.name+"在"+school+"学校学习");
    }
}
public class Homework {
    public static void main(String[] args) {
//        Person p1 = new Person("张三", 1, 20, false) {
        Person p1 = null;
        Person p2 = null;
        try {
            p1 = new Person("张三", 1, 20, false) {
                @Override
                void study(String school) {
//                Scanner scanner = new Scanner(System.in);
//                System.out.print("请输入学习时间");
//                int time = scanner.nextInt();
                    int time = 4;
                    System.out.println(getName() + "在" + school + "学校学习了" + time + "年");
                }
            };
            p2 = new Person("李四", 0, 20, false) {
                @Override
                void study(String school) {
//                Scanner scanner = new Scanner(System.in);
//                System.out.print("请输入学习时间");
//                int time = scanner.nextInt();
                    int time = 4;
                    System.out.println(getName() + "在" + school + "学校学习了" + time + "年");
                }
            };
        } catch (Exception e) {
            e.printStackTrace();
        }

        p1.study("闽江学院");
        p2.study("安徽信息工程学院");

        if (Person.marryWith(p1, p2)) {
            System.out.println("到达法律年龄，可以结婚");
        } else {
            System.out.println("未达法律年龄，不可以结婚");

        }

    }
}

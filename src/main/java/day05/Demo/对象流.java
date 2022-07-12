package day05.Demo;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.*;

/**
 * @ClassName ������
 * @Description TODO
 * @Author HP
 * @Date 9:31 2022/7/8
 * @Version 1.0
 **/
class Weapon implements  Serializable{
    private String name;

    public Weapon(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                '}';
    }
}
class Role implements Serializable {

    private String name;
    private int hp; //Ѫ��
    private int level; //�ȼ�
    private /*transient*/ Weapon weapon; //������ϵ��
    public void beatEnemy(){
        System.out.println(this.name+"�ں͵�����ս��");
    }

    public Role(String name, int hp, int level,Weapon weapon) {
        this.name = name;
        this.hp = hp;
        this.level = level;
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", level=" + level +
                ", weapon="+ weapon +
                '}';
    }
}
class Map implements Serializable{
    private int x;
    private int y;
    private String scene;//������
    public void showScene(){
        System.out.println("��ͼ�г���"+this.scene+"�������羰��");
    }
    public Map(int x, int y, String scene) {
        this.x = x;
        this.y = y;
        this.scene = scene;
    }

    @Override
    public String toString() {
        return "Map{" +
                "x=" + x +
                ", y=" + y +
                ", scene='" + scene + '\'' +
                '}';
    }
}
public class ������ {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
       // ������д���ļ�();
        ���ļ���ȡ����();
    }

    private static void ���ļ���ȡ����() throws IOException, ClassNotFoundException {
        //1 ������������ȡ�Ķ������ļ�
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("day5//1.dat"));
        //2 ���ϵĶ�ȡ�ļ���ֱ���ļ�ĩβ
        try {
            while (true) {
                Object obj = ois.readObject(); //��Ϊһ���������ȡ��
                //���ݶ�ȡ�������ڵ��࣬������ת��
                if (obj instanceof Role) {
                    ((Role) obj).beatEnemy();
                }else if(obj instanceof Map) {
                    ((Map) obj).showScene();
                }
                System.out.println(obj);
            }
        }catch (EOFException e){  //ͨ�������ļ�ĩβ�쳣��������ѭ��
            System.out.println("�ļ���ȡ������");
        }
        ois.close();
        //System.out.println("��ȡ��ϣ�");
    }

    private static void ������д���ļ�() throws IOException {
        //1 ����������д��Ķ������ļ�
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("day5//1.dat"));
        //2 ����3������
        Role r1 = new Role("����ң",50,10,new Weapon("�ɽ�"));
        Role r2 = new Role("��¥",30,80,new Weapon("��ǹ"));
        Role r3 = new Role("���½���",5000,100,new Weapon("ħ��"));
        Map map = new Map(10,20,"���ֵ�");
        //3 д�������
        oos.writeObject(r1);
        oos.writeObject(r2);
        oos.writeObject(r3);
        oos.writeObject(map);
        //4  �ر���
        oos.close();;
        System.out.println("д��ɹ���");
    }
}
/*
class Role implements Serializable {

    private String name;
    private int hp; //Ѫ��
    private int level; //�ȼ�
}
 */
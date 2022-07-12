package day05.Demo;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.*;

/**
 * @ClassName 对象流
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
    private int hp; //血量
    private int level; //等级
    private /*transient*/ Weapon weapon; //关联关系。
    public void beatEnemy(){
        System.out.println(this.name+"在和敌人作战！");
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
    private String scene;//场景名
    public void showScene(){
        System.out.println("地图中出现"+this.scene+"的美丽风景！");
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
public class 对象流 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
       // 将对象写入文件();
        从文件读取对象();
    }

    private static void 从文件读取对象() throws IOException, ClassNotFoundException {
        //1 创建对象流读取的二进制文件
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("day5//1.dat"));
        //2 不断的读取文件，直到文件末尾
        try {
            while (true) {
                Object obj = ois.readObject(); //作为一般对象来读取。
                //根据读取对象所在的类，做向下转型
                if (obj instanceof Role) {
                    ((Role) obj).beatEnemy();
                }else if(obj instanceof Map) {
                    ((Map) obj).showScene();
                }
                System.out.println(obj);
            }
        }catch (EOFException e){  //通过捕获文件末尾异常，跳出死循环
            System.out.println("文件读取结束！");
        }
        ois.close();
        //System.out.println("读取完毕！");
    }

    private static void 将对象写入文件() throws IOException {
        //1 创建对象流写入的二进制文件
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("day5//1.dat"));
        //2 创建3个对象
        Role r1 = new Role("李逍遥",50,10,new Weapon("仙剑"));
        Role r2 = new Role("重楼",30,80,new Weapon("手枪"));
        Role r3 = new Role("拜月教主",5000,100,new Weapon("魔法"));
        Map map = new Map(10,20,"仙乐岛");
        //3 写入对象流
        oos.writeObject(r1);
        oos.writeObject(r2);
        oos.writeObject(r3);
        oos.writeObject(map);
        //4  关闭流
        oos.close();;
        System.out.println("写入成功！");
    }
}
/*
class Role implements Serializable {

    private String name;
    private int hp; //血量
    private int level; //等级
}
 */
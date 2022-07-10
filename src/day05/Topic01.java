package day05;

import java.io.*;

/*1 创建类 School类：
    属性:
        name姓名,
        address住址,
        birthYear成立的年份：int （2002；2010）
实现序列化接口，void writeToFile();//采用对象流写入将两个school对象写入到 1.dat中，
void readFromFile();//从1.dat中读取数据到对象，并显示出来*/
class School implements Serializable{
    private final String name;
    private final String address;
    private final int birthYear;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public School(String name, String address, int birthYear) {
        this.name = name;
        this.address = address;
        this.birthYear = birthYear;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }

    static void writeToFile() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/day05/file/1.dat"));
        School s1 = new School("张三", "泉州市", 2002);
        School s2 = new School("李四", "晋江市", 2010);
        oos.writeObject(s1);
        oos.writeObject(s2);
        oos.close();
        System.out.println("写入成功");
    }



    static void readFromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/day05/file/1.dat"));
//        ois.readObject()
        try {
            while (true) {
                Object obj = ois.readObject();
                System.out.println(obj);
            }
        } catch (EOFException e) {
            System.out.println("文件读取结束");
        }
    }
}

public class Topic01 {
//    属性:
//    name姓名,
//    address住址,
//    birthYear成立的年份：int （2002；2010）
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        School.writeToFile();
        School.readFromFile();
    }
}

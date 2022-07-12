package day05;

import java.io.*;

/*1 ������ School�ࣺ
    ����:
        name����,
        addressסַ,
        birthYear��������ݣ�int ��2002��2010��
ʵ�����л��ӿڣ�void writeToFile();//���ö�����д�뽫����school����д�뵽 1.dat�У�
void readFromFile();//��1.dat�ж�ȡ���ݵ����󣬲���ʾ����*/
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
        School s1 = new School("����", "Ȫ����", 2002);
        School s2 = new School("����", "������", 2010);
        oos.writeObject(s1);
        oos.writeObject(s2);
        oos.close();
        System.out.println("д��ɹ�");
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
            System.out.println("�ļ���ȡ����");
        }
    }
}

public class Topic01 {
//    ����:
//    name����,
//    addressסַ,
//    birthYear��������ݣ�int ��2002��2010��
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        School.writeToFile();
        School.readFromFile();
    }
}

package day05.Demo;


import java.io.*;

/**
 * @ClassName ��������
 * @Description TODO
 * @Author HP
 * @Date 10:23 2022/7/8
 * @Version 1.0
 **/
public class �������� {
    public static void main(String[] args) throws IOException {
       // ������д��();
        �����ƶ�ȡ();
    }

    private static void �����ƶ�ȡ() throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("day5/2.dat"));
        System.out.println(dis.readInt());
        System.out.println(dis.readFloat());
        System.out.println(dis.readUTF());
        dis.close();
    }

    private static void ������д��() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("day5/2.dat"));
        dos.writeInt(10);
        dos.writeFloat(10.f);
        dos.writeUTF("�����ϰ�");
        dos.flush();//���ڴ�����ջ�������
        dos.close();;
        System.out.println("д����ϣ�");
    }
}

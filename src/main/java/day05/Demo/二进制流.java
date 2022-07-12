package day05.Demo;


import java.io.*;

/**
 * @ClassName 二进制流
 * @Description TODO
 * @Author HP
 * @Date 10:23 2022/7/8
 * @Version 1.0
 **/
public class 二进制流 {
    public static void main(String[] args) throws IOException {
       // 二进制写入();
        二进制读取();
    }

    private static void 二进制读取() throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("day5/2.dat"));
        System.out.println(dis.readInt());
        System.out.println(dis.readFloat());
        System.out.println(dis.readUTF());
        dis.close();
    }

    private static void 二进制写入() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("day5/2.dat"));
        dos.writeInt(10);
        dos.writeFloat(10.f);
        dos.writeUTF("我是老白");
        dos.flush();//从内存中清空缓冲区。
        dos.close();;
        System.out.println("写入完毕！");
    }
}

package day04;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*  1 ʹ�ô������㣬����
    4444444.4444/3.333333��ֵ������2λС������������
    2  ���������յ�ǰһ�ܵ������Ǹ���ĵڼ��죿
    Calendar:set�������õ�������գ�
    add��������ǰһ�ܵ����ģ�ͨ�� xxxx����Ǹ���ĵڼ���? get(Calendar.DAY_OF_YEAR)
    3���ݹ����srcĿ¼�е�����.java�ļ��ľ���·����
    4���ڵ���D���´���һ���ļ�ΪHelloWorld.txt�ļ����ж������ļ�����Ŀ¼���ٴ���һ��Ŀ¼IOTest��֮��HelloWorld.txt������IOTestĿ¼��a.txtȥ��
    5����utf-8�����ʽ���ı����Ƶ�GBK������ı������ܳ������룩*/
public class Topic4 {
//    static String pathFolder = "D:\\tempCode\\Сѧ����ҵ\\resp\\src\\day04\\IOTest";
    static String pathFile_a = "D:\\tempCode\\Сѧ����ҵ\\resp\\src\\day04\\IOTest\\a.txt";
    static String pathFile = "D:\\HelloWorld.txt";
//    static File file;
//    static File folder;

    public static void main(String[] args) throws IOException {
        File file = new File(pathFile);
        touch(file);
//        File folder = new File(pathFolder);
//        touch(folder);
        File file_a = new File(pathFile_a);
        touch(file_a);
        InputStream in = new FileInputStream(file);
        OutputStream out = new FileOutputStream(file_a);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = in.read(buffer)) > 0) {
            out.write(buffer, 0, length);
        }
    }

    private static void touch(File f) throws IOException {


        if (f.createNewFile()) {
            if (f.isFile()) {
                System.out.println("�����ļ��ɹ�");
            } else {
                System.out.println("����Ŀ¼�ɹ�");
            }
        } else {
                System.out.println("����ʧ��");
        }
    }

//    private static void closeUtil() {
//        file.delete();
//        folder.delete();
//
//    }


}

package day04;

import java.io.File;
import java.io.FileFilter;

/*  1 ʹ�ô������㣬����
    4444444.4444/3.333333��ֵ������2λС������������
    2  ���������յ�ǰһ�ܵ������Ǹ���ĵڼ��죿
    Calendar:set�������õ�������գ�
    add��������ǰһ�ܵ����ģ�ͨ�� xxxx����Ǹ���ĵڼ���? get(Calendar.DAY_OF_YEAR)
    3���ݹ����srcĿ¼�е�����.java�ļ��ľ���·����
    4���ڵ���D���´���һ���ļ�ΪHelloWorld.txt�ļ����ж������ļ�����Ŀ¼���ٴ���һ��Ŀ¼IOTest��֮��HelloWorld.txt������IOTestĿ¼��a.txtȥ��
    5����utf-8�����ʽ���ı����Ƶ�GBK������ı������ܳ������룩*/
public class Topic3 {
    public static void main(String[] args) {
        String path = "D:\\tempCode\\Сѧ����ҵ\\resp\\src";
        File file = new File(path);
        isFile(file, path);


    }

    static void isFile(File fileList, String path) {

        for (String s : fileList.list()) {
            String tempPath = path + "\\" + s;
            File file0 = new File(tempPath);
            if (file0.isFile()) {

                if (tempPath.endsWith(".java")) {
                    System.out.println(s);
                }
            } else {
                isFile(file0, tempPath);
            }
        }
        return;
    }
}

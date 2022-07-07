package day04;

import java.io.*;
import java.nio.charset.StandardCharsets;

/*  1 ʹ�ô������㣬����
    4444444.4444/3.333333��ֵ������2λС������������
    2  ���������յ�ǰһ�ܵ������Ǹ���ĵڼ��죿
    Calendar:set�������õ�������գ�
    add��������ǰһ�ܵ����ģ�ͨ�� xxxx����Ǹ���ĵڼ���? get(Calendar.DAY_OF_YEAR)
    3���ݹ����srcĿ¼�е�����.java�ļ��ľ���·����
    4���ڵ���D���´���һ���ļ�ΪHelloWorld.txt�ļ����ж������ļ�����Ŀ¼���ٴ���һ��Ŀ¼IOTest��֮��HelloWorld.txt������IOTestĿ¼��a.txtȥ��
    5����utf-8�����ʽ���ı����Ƶ�GBK������ı������ܳ������룩*/
public class Topic5 {
    public static void main(String[] args) throws IOException {
        File file1=new File("d:/utf-8.txt");
        File file2=new File("d:/GBK.txt");
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(file1), StandardCharsets.UTF_8)) {
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file2, true), "gbk");
            int len;
            char[] buf = new char[1024];

            while ((len = isr.read(buf)) != -1) {
                osw.write(buf, 0, len);
                osw.flush();
            }
            osw.close();
            isr.close();
        }
        System.out.println("�ļ����Ƴɹ�");
    }
}

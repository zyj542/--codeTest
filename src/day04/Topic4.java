package day04;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*  1 使用大数运算，就算
    4444444.4444/3.333333的值，保留2位小数，四舍五入
    2  输入你生日的前一周的周四是该年的第几天？
    Calendar:set方法设置到你的生日，
    add方法跳到前一周的周四，通过 xxxx获得是该年的第几天? get(Calendar.DAY_OF_YEAR)
    3、递归输出src目录中的所有.java文件的绝对路径。
    4、在电脑D盘下创建一个文件为HelloWorld.txt文件，判断他是文件还是目录，再创建一个目录IOTest，之后将HelloWorld.txt拷贝到IOTest目录的a.txt去。
    5、从utf-8编码格式的文本复制到GBK编码的文本（不能出现乱码）*/
public class Topic4 {
//    static String pathFolder = "D:\\tempCode\\小学期作业\\resp\\src\\day04\\IOTest";
    static String pathFile_a = "D:\\tempCode\\小学期作业\\resp\\src\\day04\\IOTest\\a.txt";
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
                System.out.println("创建文件成功");
            } else {
                System.out.println("创建目录成功");
            }
        } else {
                System.out.println("创建失败");
        }
    }

//    private static void closeUtil() {
//        file.delete();
//        folder.delete();
//
//    }


}

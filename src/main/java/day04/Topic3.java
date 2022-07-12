package day04;

import java.io.File;
import java.io.FileFilter;

/*  1 使用大数运算，就算
    4444444.4444/3.333333的值，保留2位小数，四舍五入
    2  输入你生日的前一周的周四是该年的第几天？
    Calendar:set方法设置到你的生日，
    add方法跳到前一周的周四，通过 xxxx获得是该年的第几天? get(Calendar.DAY_OF_YEAR)
    3、递归输出src目录中的所有.java文件的绝对路径。
    4、在电脑D盘下创建一个文件为HelloWorld.txt文件，判断他是文件还是目录，再创建一个目录IOTest，之后将HelloWorld.txt拷贝到IOTest目录的a.txt去。
    5、从utf-8编码格式的文本复制到GBK编码的文本（不能出现乱码）*/
public class Topic3 {
    public static void main(String[] args) {
        String path = "D:\\tempCode\\小学期作业\\resp\\src";
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

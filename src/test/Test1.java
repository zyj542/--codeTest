package test;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

//import  java.util.Date
public class Test1 {
    public static void main(String[] args) {
        Date date = new Date();
//        month
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("y-M-d h:m:s");
        System.out.println(simpleDateFormat.format(date) instanceof String);

        File file = new File("D:\\tempCode\\小学期作业\\resp\\src\\test\\Test1.java");
        System.out.println(file.length());
    }
}

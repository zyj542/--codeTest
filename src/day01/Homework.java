package day01;

import java.util.Random;
import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {
        /*今天作业：
        1输入密码长度，至少6位
        2生成随机密码字符串并输出，要求同时包含大写字母及数字
        请大家尽量21:30之前传自己仓库*/

        Scanner scanner = new Scanner(System.in);
        int length;
        do {
            System.out.print("请输入密码长度，至少六位：");
            length = scanner.nextInt();
        } while (length < 6);

        char[] chars = new char[10 + 26 + 26];
        for (int i = 0; i < 10; i++) {
            chars[i] = (char) ('0' + i);
            chars[i + 10] = (char) ('A' + i);
        }

        for (int i = 0; i <  26; i++) {
            chars[i + 10 + 26] = (char) ('a' + i);
        }
//        System.out.println(chars);

        Random random = new Random();
        String password = "";
        for (int i = 0; i < length; i++) {
            password += chars[random.nextInt(10 + 26 + 26)] + "";
        }
        System.out.println("该随机密码为："+password);
    }
}
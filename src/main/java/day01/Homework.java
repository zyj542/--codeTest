package day01;

import java.util.Random;
import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {
        /*������ҵ��
        1�������볤�ȣ�����6λ
        2������������ַ����������Ҫ��ͬʱ������д��ĸ������
        ���Ҿ���21:30֮ǰ���Լ��ֿ�*/

        Scanner scanner = new Scanner(System.in);
        int length;
        do {
            System.out.print("���������볤�ȣ�������λ��");
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
        System.out.println("���������Ϊ��"+password);
    }
}
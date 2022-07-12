package test;

//import day05.Student;

import java.util.ArrayList;
import java.util.Collections;

public class Test1 {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        ArrayList<Integer> a = new ArrayList<>();
        Collections.addAll(a, 4, 51, 2, 23, 21, 2, 1);
        System.out.println("≈≈–Ú«∞£∫" + a);
        Collections.sort(a);
        System.out.println("≈≈–Ú∫Û£∫" + a);
    }
}


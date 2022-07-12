package day05.Demo;

import java.util.Iterator;

import java.util.function.Consumer;

/**
 * @ClassName 迭代器设计模式
 * @Description TODO
 * @Author HP
 * @Date 15:27 2022/7/8
 * @Version 1.0
 **/
class 福建景点 implements  Iterable<String> {  //实现可迭代接口
    private String str1 = "鼓浪屿";  //第1个字符串
    private String str2 = "三清山";  //第2个字符串
    private String str3 = "大金湖"; //第3个字符串
    private int index = 0;
    private Iterator<String> it = new Iterator<String>() {
        @Override
        public boolean hasNext() {  //有没有下一个
            if (index < 3) //总共只有3个字符串可以遍历
                return true;
            return false;
        }

        @Override
        public String next() {  //下一个是谁
            if (index == 0) {
                index++;
                return str1;
            }
            if (index == 1) {
                index++;
                return str2;
            }
            if (index == 2) {
                index++;
                return str3;
            }
            return null;
        }
    }; //拥有一个迭代器

    @Override
    public Iterator<String> iterator() {
        return it;
    }
}

public class 迭代器设计模式 {
    public static void main(String[] args) {
        福建景点 m = new 福建景点();
        //只要实现迭代器模式，就能使用增强for循环
        for(String str:m){
            System.out.println(str);
        }
        System.out.println("----------------------");
        //直接使用迭代器进行遍历
        福建景点 m2 = new 福建景点();
        Iterator<String> it = m2.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}

package day06;

import java.util.*;
import java.util.stream.Stream;


class Book implements Comparable<Book>{
    private final int bid;
    private final String bname;
    private final float price;

    public int getBid() {
        return bid;
    }

    public String getBname() {
        return bname;
    }

    public float getPrice() {
        return price;
    }

    public Book(int bid, String bname, float price) {
        this.bid = bid;
        this.bname = bname;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Book o) {
        return Integer.compare((int) this.getPrice(), (int) o.getPrice())*-1;
    }


}

class BookCompartor implements Comparator<Book> {



    @Override
    public int compare(Book o1, Book o2) {
        return Integer.compare((int) o1.getPrice(), (int) o2.getPrice());
    }
}
/*
    1 ����Book�ࣺ int bid����ţ�,String bname,float price

    2 ���� TreeMap<Book,String> map;����5���飬
    map.put(new Book(1,"���μ�",100),"�ϰ�");
    Ҫ����ļ۸�Ӹߵ������������
    ʹ����������������  keySet������entrySet����

    3  ����   ArrayList<Book> list;���5���飬
    ʹ�� stream���㣬���۸����150Ԫ���飬����Ŵӵ͵��������
��ʾ    filter(?).sort(new BookCompartor()).forEach(...)
*/
public class Topic01 {
    public static void main(String[] args) {
        task1();
        task2();

    }

    private static void task2() {
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book(1,"���μ�",75));
        list.add(new Book(2,"��ƿ÷",364));
        list.add(new Book(3,"��¥��",56.6f));
        list.add(new Book(4,"��������",49));
        list.add(new Book(5, "ˮ䰴�", 59));
        Stream<Book> stream = list.stream();
        stream.filter((book -> book.getPrice()<150)).sorted(new BookCompartor()).distinct().forEach(System.out::println);
    }

    private static void task1() {
        TreeMap<Book, String> map = new TreeMap<>();
        map.put(new Book(1,"���μ�",75),"��ж�");
        map.put(new Book(2,"��ƿ÷",364),"����ЦЦ��");
        map.put(new Book(3,"��¥��",56.6f),"��ѩ��");
        map.put(new Book(4,"��������",49),"�޹���");
        map.put(new Book(5, "ˮ䰴�", 59), "ʩ����");
        for (Book key : map.keySet()) {
            System.out.println("\t���:"+key.getBid()+"\t����:"+key.getBname()+"\t�۸�:"+key.getPrice()+"\t����:"+map.get(key));

        }
        System.out.println("================");
        for(Map.Entry<Book,String> e:map.entrySet()){
            Book key = e.getKey();
            System.out.println("\t���:"+key.getBid()+"\t����:"+key.getBname()+"\t�۸�:"+key.getPrice()+"\t����:"+map.get(key));
        }
    }

}

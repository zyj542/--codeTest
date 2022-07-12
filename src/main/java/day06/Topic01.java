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
    1 创建Book类： int bid（编号）,String bname,float price

    2 创建 TreeMap<Book,String> map;加入5本书，
    map.put(new Book(1,"西游记",100),"老白");
    要求按书的价格从高到低排序输出。
    使用两个遍历方法：  keySet遍历，entrySet遍历

    3  创建   ArrayList<Book> list;添加5本书，
    使用 stream运算，将价格低于150元的书，按编号从低到高输出。
提示    filter(?).sort(new BookCompartor()).forEach(...)
*/
public class Topic01 {
    public static void main(String[] args) {
        task1();
        task2();

    }

    private static void task2() {
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book(1,"西游记",75));
        list.add(new Book(2,"金瓶梅",364));
        list.add(new Book(3,"红楼梦",56.6f));
        list.add(new Book(4,"三国演义",49));
        list.add(new Book(5, "水浒传", 59));
        Stream<Book> stream = list.stream();
        stream.filter((book -> book.getPrice()<150)).sorted(new BookCompartor()).distinct().forEach(System.out::println);
    }

    private static void task1() {
        TreeMap<Book, String> map = new TreeMap<>();
        map.put(new Book(1,"西游记",75),"吴承恩");
        map.put(new Book(2,"金瓶梅",364),"兰陵笑笑生");
        map.put(new Book(3,"红楼梦",56.6f),"曹雪芹");
        map.put(new Book(4,"三国演义",49),"罗贯中");
        map.put(new Book(5, "水浒传", 59), "施耐庵");
        for (Book key : map.keySet()) {
            System.out.println("\t编号:"+key.getBid()+"\t书名:"+key.getBname()+"\t价格:"+key.getPrice()+"\t作者:"+map.get(key));

        }
        System.out.println("================");
        for(Map.Entry<Book,String> e:map.entrySet()){
            Book key = e.getKey();
            System.out.println("\t编号:"+key.getBid()+"\t书名:"+key.getBname()+"\t价格:"+key.getPrice()+"\t作者:"+map.get(key));
        }
    }

}

package test;


import java.util.Objects;

class student {
    String sname;
    String sid;

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public student(String sname) {
        this.sname = sname;
    }

    @Override
    public boolean equals(Object o) {



        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        student student = (student) o;
        return Objects.equals(sname, student.sname) && Objects.equals(sid, student.sid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sname, sid);
    }
}

public class Test {
    public static void main(String[] args) {


    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

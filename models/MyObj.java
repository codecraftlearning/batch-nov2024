package models;

public class MyObj implements Comparable<MyObj> {
    public Integer roll;
    public String name;

    public MyObj(Integer roll, String name) {
        this.roll = roll;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("[%d, %s]", roll, name);
    }

    @Override
    public int compareTo(MyObj o) {
        return this.roll - o.roll;
    }
}

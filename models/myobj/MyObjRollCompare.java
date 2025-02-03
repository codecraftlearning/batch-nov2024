package models.myobj;

public class MyObjRollCompare extends MyObj implements Comparable<MyObj> {
    public MyObjRollCompare(Integer roll, String name) {
        super(roll, name);
    }

    @Override
    public int compareTo(MyObj o) {
        return this.roll - o.roll;
    }
}

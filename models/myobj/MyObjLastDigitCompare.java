package models.myobj;

public class MyObjLastDigitCompare extends MyObj implements Comparable<MyObj> {
    public MyObjLastDigitCompare(Integer roll, String name) {
        super(roll, name);
    }

    @Override
    public int compareTo(MyObj o) {
        return this.roll%10 - o.roll%10;
    }
}

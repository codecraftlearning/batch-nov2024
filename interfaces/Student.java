package interfaces;

import models.Mobile;

public class Student extends Mobile implements IPerson, IStudent {

    private String name;
    private String gender;
    private Double height;
    private Double weight;

    private  Integer roll;
    private Integer classNumber;
    private Integer rank;

    public Student(String name, String gender, Double height, Double weight) {
        super("samsung", "s1", 40000.00);
        this.name = name;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
    }


    @Override
    public String getGender() {
        return this.gender;
    }

    @Override
    public Double getHeight() {
        return this.height;
    }

    @Override
    public Double getWeight() {
        return this.weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public Integer getRoll() {
        return this.roll;
    }

    @Override
    public Integer getClassNumber() {
        return this.classNumber;
    }

    @Override
    public Integer getRank() {
        return this.rank;
    }

    public void setRoll(Integer roll) {
        this.roll = roll;
    }

    public void setClassNumber(Integer classNumber) {
        this.classNumber = classNumber;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getPetName() {
        return IStudent.super.getPetName();
    }

    //    @Override
//    public Double calculateBMI() {
//        return 0D;
//    }
}


/*

A ->   x  => A.x = #
B ->   x  => B.x = *

AB <- A,B  => A. = &


I1 -> x => I1.x => ?????
I2 -> x => I2.x => ?????

S <- I1, I2 => I2.x = #  ->
 */

package models;

import constants.Identifications;
import enums.Complexion;
import enums.Gender;

import java.io.Serializable;
import java.util.ArrayList;

public class Person implements Serializable, Cloneable {
    private String name;
    private Integer age;
    private Double height;
    private Double weight;
    private Complexion complexion;
    private Gender gender;
    private Integer legCount = Identifications.DEFAULT_LEGS_COUNT;
    private ArrayList<String> clasees = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Complexion getComplexion() {
        return complexion;
    }

    public void setComplexion(Complexion complexion) {
        this.complexion = complexion;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getLegCount() {
        return legCount;
    }

    public void setLegCount(Integer legCount) {
        this.legCount = legCount;
    }

    public ArrayList<String> getClasees() {
        return clasees;
    }

    public void setClasees(ArrayList<String> clasees) {
        this.clasees = clasees;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", complexion='" + complexion + '\'' +
                '}';
    }

    @Override
    public Person clone()  {
        try {
            Person clone = (Person) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

package models;

import constants.Identifications;
import enums.Complexion;
import enums.Gender;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private Integer age;
    private Double height;
    private Double weight;
    private Complexion complexion;
    private Gender gender;
    private Integer legCount = Identifications.DEFAULT_LEGS_COUNT;

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
}

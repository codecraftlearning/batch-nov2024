package models;

import enums.Gender;

public class Employee extends Object{

    private String name;
    private Long id;
    private Integer age;
    private Gender gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals (Object emp) {
        if (emp == null) {
            return false;
        }

        if (emp.getClass() != this.getClass()) {
            return false;
        }

        Employee e = (Employee) emp;
        boolean isEqual = true;

        isEqual &= this.getGender().equals(e.getGender());
        isEqual &= this.getAge().equals(e.getAge());
        isEqual &= this.getId().equals(e.getId());
        isEqual &= this.getName().equals(e.getName());

        return isEqual;
    }


    @Override
    public int hashCode() {
        return Math.toIntExact(this.getId());
    }

    @Override
    public String toString() {
        return ""+this.getId();
    }
}

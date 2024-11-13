package models;

public class Student {
    private Integer rollNumber;
    private String name;
    private String className;
    private String gender;
    private String address;
    private Long phoneNumber;
    private Integer age;
    private Double height;
    private Double weight;

    public Student rollNumber(Integer rollNumber) {
        this.rollNumber = rollNumber;
        return this;
    }

    public Student age(Integer age) {
        this.age = age;
        return this;
    }

    public Student() {}

    public Student(Builder builder) {
        this.rollNumber = builder.rollNumber;
        this.name = builder.name;
        this.className = builder.className;
        this.gender = builder.gender;
        this.address = builder.address;
        this.phoneNumber = builder.phoneNumber;
        this.age = builder.age;
        this.height = builder.height;
        this.weight = builder.weight;
    }

    public Integer getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(Integer rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    @Override
    public String toString() {
        return "Student{" +
                "rollNumber=" + rollNumber +
                ", name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }

    public static class Builder {
        private Integer rollNumber;
        private String name;
        private String className;
        private String gender;
        private String address;
        private Long phoneNumber;
        private Integer age;
        private Double height;
        private Double weight;

        public Builder rolNumber(Integer rollNumber) {
            this.rollNumber = rollNumber;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder className(String className) {
            this.className = className;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder phoneNumber(Long phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }
        public Builder age(Integer age) {
            this.age = age;
            return this;
        }
        public Builder height(Double height) {
            this.height = height;
            return this;
        }
        public Builder weight(Double weight) {
            this.weight = weight;
            return this;
        }
        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}

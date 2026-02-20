package com.ankit;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student {

    @Id
    private int rollNo;
    private int age;
    private String sName;

    @OneToMany(mappedBy = "sid", fetch = FetchType.EAGER)
    private List<Laptop> laptops;

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", age=" + age +
                ", sName='" + sName + '\'' +
                ", laptop=" + laptops +
                '}';
    }
}

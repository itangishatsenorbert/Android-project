package com.example.norbertactivity.model;

public class Child {
    private int id; // Assuming you also want to store the ID
    private int age;
    private String name;
    private boolean enrolled;
    private String grade; // Assuming you have a grade field

    // Constructor
    public Child(int id, int age, String name, boolean enrolled, String grade) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.enrolled = enrolled;
        this.grade = grade;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public boolean isEnrolled() {
        return enrolled;
    }

    public String getGrade() {
        return grade;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEnrolled(boolean enrolled) {
        this.enrolled = enrolled;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

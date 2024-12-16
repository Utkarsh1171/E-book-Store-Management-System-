package com.example.excelupload.model;

public class Student {

    private String name;
    private String gender;
    private double marks;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{"
                + "name='" + name + '\''
                + ", gender='" + gender + '\''
                + ", marks=" + marks
                + '}';
    }
}

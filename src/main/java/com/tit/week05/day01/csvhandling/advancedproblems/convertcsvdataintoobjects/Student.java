package com.tit.week05.day01.csvhandling.advancedproblems.convertcsvdataintoobjects;

public class Student {
    private String ID;
    private String Name;
    private int Age;
    private int Marks ;

    @Override
    public String toString() {
        return "Student{ID='" + ID + "', Name='" + Name + "', Age=" + Age + ", Marks=" + Marks + "}";
    }
}


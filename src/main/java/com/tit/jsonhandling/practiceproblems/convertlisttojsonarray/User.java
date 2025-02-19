package com.tit.jsonhandling.practiceproblems.convertlisttojsonarray;

public class User {
    private String name;
    private int age;

    // Constructors
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and Setters (needed for Jackson)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

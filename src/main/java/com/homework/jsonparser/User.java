package com.homework.jsonparser;

public class User {

    private int age;
    private String name;

    public User(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder();
         stb
            .append("\n")
            .append(" {")
            .append("\n\n")
            .append('"')
            .append("name")
            .append('"')
            .append(':')
            .append('"')
            .append(name)
            .append('"')
            .append(',')
            .append("\n\n")
            .append('"')
            .append("age")
            .append('"')
            .append(':')
            .append(age)
            .append("\n")
            .append("\n")
            .append(" },")
            .append("\n");
        return  stb.toString();
    }
}

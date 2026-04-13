package org.example.demo.model;

public class Person {
    private int id;
    private String name;
    private int age;
    private boolean gender;
    private String url;

    public Person() {
    }

    public Person(boolean gender, int age, String name, int id, String url) {
        this.gender = gender;
        this.age = age;
        this.name = name;
        this.id = id;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

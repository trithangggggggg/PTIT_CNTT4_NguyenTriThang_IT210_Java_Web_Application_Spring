package com.demo.model;

public class Student {
    private String fullName;
    private double score;

    public Student(String fullName, double score) {
        this.fullName = fullName;
        this.score = score;
    }

    public String getFullName() {
        return fullName;
    }

    public double getScore() {
        return score;
    }
}
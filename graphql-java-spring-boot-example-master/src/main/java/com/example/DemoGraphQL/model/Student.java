package com.example.DemoGraphQL.model;

import java.io.Serializable;

public class Student implements Serializable {
  private static int ID = 1;
  private int id;
  private String name;
  private int semester;
  private float gpa;

  public Student() {
  }

  public Student(String name, int semester, float gpa) {
    this.id = ID;
    ID+=1;
    this.name = name;
    this.semester = semester;
    this.gpa = gpa;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getSemester() {
    return semester;
  }

  public void setSemester(int semester) {
    this.semester = semester;
  }

  public float getGpa() {
    return gpa;
  }

  public void setGpa(float gpa) {
    this.gpa = gpa;
  }
}

package com.example.DemoGraphQL.model;

import java.io.Serializable;

public class StudentInput implements Serializable {

  private int id;
  private String name;
  private int semester;
  private float gpa;

  public StudentInput() {
  }

  public StudentInput(int id, String name, int semester, float gpa) {
    this.id = id;
    this.name = name;
    this.semester = semester;
    this.gpa = gpa;
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

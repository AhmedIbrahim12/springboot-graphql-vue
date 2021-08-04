package com.example.DemoGraphQL.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.DemoGraphQL.model.Student;
import com.example.DemoGraphQL.model.StudentInput;

public class StudentsRepo {

  private final List<Student> students;

  public StudentsRepo() {
    students = new ArrayList<>();
    students.add(new Student("ahmed",10,3.6f));
    students.add(new Student("alaa",10,3.8f));
    //add some links to start off with
  }

  public List<Student> getAllStudents() {
    return students;
  }

  public Student saveOrUpdateStudent(StudentInput studentInput) {
    Student student;
    if(studentInput.getId() == 0 ){
      student = new Student(studentInput.getName(),studentInput.getSemester(),studentInput.getGpa());
      students.add(student);
    }else{
      student = students.stream()
          .filter(s -> s.getId() == studentInput.getId())
          .findFirst().get();
      student.setName(studentInput.getName());
      student.setGpa(studentInput.getGpa());
      student.setSemester(studentInput.getSemester());
    }
    return student;
  }

  public void deleteStudent(Student student) {
    students.remove(student);
  }
}

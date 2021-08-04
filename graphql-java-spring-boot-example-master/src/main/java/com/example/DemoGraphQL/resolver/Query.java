package com.example.DemoGraphQL.resolver;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.DemoGraphQL.model.Student;
import com.example.DemoGraphQL.repository.StudentsRepo;

public class Query implements GraphQLQueryResolver {

    private final StudentsRepo studentsRepo;

    public Query(StudentsRepo studentsRepo) {
        this.studentsRepo = studentsRepo;
    }

    public List<Student> allStudents(String name) {
        return studentsRepo.getAllStudents();
    }

}

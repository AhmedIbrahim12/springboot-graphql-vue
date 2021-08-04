package com.example.DemoGraphQL.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.DemoGraphQL.model.Student;
import com.example.DemoGraphQL.model.StudentInput;
import com.example.DemoGraphQL.repository.StudentsRepo;

public class Mutation implements GraphQLMutationResolver {
	private final StudentsRepo studentsRepo;

    public Mutation(StudentsRepo studentsRepo) {
        this.studentsRepo = studentsRepo;
    }

    public Student saveStudent(StudentInput studentInput){
        return studentsRepo.saveOrUpdateStudent(studentInput);
    }

    public Student updateStudent(StudentInput studentInput){
        return studentsRepo.saveOrUpdateStudent(studentInput);
    }
}

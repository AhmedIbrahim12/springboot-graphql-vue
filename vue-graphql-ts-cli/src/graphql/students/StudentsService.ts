import {apolloClient} from "../../main";
import {Student, StudentInput} from "./Student";

export interface StudentResult{
    allStudents : Student[];
    createStudent : Student;
    updateStudent : Student;
}

export default class StudentService {

    async findAllStudents() : Promise<Student[]>{
        const response = await apolloClient.query({
            query: require("./find.gql"),
            fetchPolicy: 'no-cache'
        });
        
        const result : StudentResult = response.data;
        return result.allStudents;
    }

    async createStudent(student: StudentInput) : Promise<Student>{
        const response = await apolloClient.mutate({
            mutation: require("./saveMutation.gql"),
            variables: {
                student: student
            }
        });

        const result : StudentResult = response.data;
        return result.createStudent;
    }

    async updateStudent(student: StudentInput) : Promise<Student>{
        const response = await apolloClient.mutate({
            mutation: require("./updateMutation.gql"),
            variables: {
                student: student
            }
        });
        
        const result : StudentResult = response.data;
        return result.updateStudent;
    }
}

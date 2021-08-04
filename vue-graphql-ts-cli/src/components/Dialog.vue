<template>
            <v-dialog
                v-model="dialog"
                max-width="500px"
            >
                <v-card>
                    <v-card-title>
                        <span class="text-h5">{{ formTitle }}</span>
                    </v-card-title>
    
                <v-card-text>
                    <v-container>
                    <v-row>
                        <v-col
                        cols="12"
                        sm="6"
                        md="4">
                            <v-text-field
                                v-model="student.name"
                                label="Name"
                            ></v-text-field>
                        </v-col>
                        <v-col
                        cols="12"
                        sm="6"
                        md="4">
                            <v-text-field
                                v-model="student.semester"
                                label="Semester"
                            ></v-text-field>
                        </v-col>
                        <v-col
                        cols="12"
                        sm="6"
                        md="4">
                            <v-text-field
                                v-model="student.gpa"
                                label="GPA (4)"
                            ></v-text-field>
                        </v-col>
                    </v-row>
                    </v-container>
                </v-card-text>
    
                <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn
                    color="blue darken-1"
                    text
                    @click="close"
                    >
                    Cancel
                    </v-btn>
                    <v-btn
                    color="blue darken-1"
                    text
                    @click="save"
                    >
                    Save
                    </v-btn>
                </v-card-actions>
                </v-card>
            </v-dialog>
</template>
<script lang="ts">
import { Component, Vue, Prop, Watch } from 'vue-property-decorator';
import {Student, StudentInput} from "../graphql/students/Student";
import {eventBus} from "../main";
import {studentsService} from "../main";

@Component
export default class Dialog extends Vue{

    @Prop() readonly dialog!: boolean;
    @Prop() readonly student!: Student;

    private edited = false;

    @Watch('dialog')
    onDialogChanged(val: string, oldVal: string): void {
        this.edited = this.student.id != 0;
    }

    get formTitle() : string {
        return this.edited? "Edit Student" : "Add Student";
    }

    close(){
        eventBus.$emit("afterClose");
    }

    save(){
        var response;
        if(this.edited){
             response = studentsService.updateStudent(this.createStudentInput(this.student));
        }else{
            response = studentsService.createStudent(this.createStudentInput(this.student));
        }
        response.then(data => eventBus.$emit("afterSave"));
    }

    private createStudentInput(student : Student) : StudentInput {
        return {
            id : student.id,
            name: student.name,
            semester: student.semester,
            gpa: student.gpa
        };
    }
}
</script>
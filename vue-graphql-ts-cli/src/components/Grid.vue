<template>
    <div>
        <v-data-table
        :headers="headers"
        :items="students"
        class="elevation-1"
        >
        <template v-slot:top>
            <v-toolbar flat>
            <v-toolbar-title>Students Widget</v-toolbar-title>
            <v-divider
                class="mx-4"
                inset
                vertical
            ></v-divider>
            <v-spacer></v-spacer>
            <v-btn
                color="primary"
                dark
                class="mb-2"
                @click="showDialog(true)"
              >
                New Item
              </v-btn>
            </v-toolbar>
        </template>
        <template v-slot:item.actions="{ item }">
            <v-icon
            small
            class="mr-2"
            @click="editStudent(item)"
            >
            mdi-pencil
            </v-icon>
            <v-icon
            small
            @click="deleteStudent(item)"
            >
            mdi-delete
            </v-icon>
        </template>
        </v-data-table>

        <student-dialog 
            :dialog="dialog"
            :student="editedStudent"
        ></student-dialog>
    </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import Dialog from './Dialog.vue';
import {Student} from "../graphql/students/Student";
import {eventBus} from "../main";
import {studentsService} from "../main";

@Component({
  components: {
      'student-dialog' : Dialog
  }
})
export default class Grid extends Vue{

    private headers: Record<string, unknown>[] = [];
    private dialog = false;
    private students: Student[] = [];
    private editedStudent: Student = {};
    private dialogDelete = false;

    created(){
        this.createGridHeaders();
        this.resetStudent();
        this.registerEventHandlers();
    }

    mounted(){
       this.reloadGrid();
    }

    private createGridHeaders(){
        this.headers = [{text: 'Name', value: 'name'},
                {text: 'Semester', value: 'semester'},
                {text: 'GPA', value: 'gpa'},
                {text: 'Actions', value: 'actions', sortable: false }];
    }

    private registerEventHandlers(){
        eventBus.$on("afterClose", (data:any) => this.afterClose());
        eventBus.$on("afterSave", (data: any) => {
            this.afterClose();
            this.reloadGrid();
        })
    }

    afterClose(){
        this.showDialog(false);
        this.resetStudent();
    }

    reloadGrid(){
        const response = studentsService.findAllStudents();
        response.then(data => this.students = data);
    }


    editStudent(student: Student){
        Object.assign(this.editedStudent , student);
        this.showDialog(true);
    }


    showDialog(show : boolean){
        this.dialog = show;
    }

    private resetStudent(){
        this.editedStudent = {
                id: 0,
                name: "",
                semester: 0,
                gpa: 0
        };
    }
}
</script>
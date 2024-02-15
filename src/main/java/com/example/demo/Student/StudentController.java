package com.example.demo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/Student")
public class StudentController {


    public final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();

    }

    @PostMapping
    public void RegisterNewStudent(@RequestBody Student student){
    studentService.addNewStudent(student);

        }


        @DeleteMapping(path="{studentId}")
        public void DeleteStudent(@PathVariable("studentId")Long studentId){
        studentService.DeleteStudent(studentId);
        }

        @PutMapping(path = "{studentId}/{studentName}/{studentEmail}")
    public void updateStudent(@PathVariable("studentId") Long studentId,
                        @PathVariable("studentName")String studentName,
                        @PathVariable("studentEmail")String studentEmail){

        studentService.updateStudent(studentId,studentName,studentEmail);

    }




}

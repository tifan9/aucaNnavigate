package com.auca.auca_navigate.controller;

import com.auca.auca_navigate.domain.Student;
import com.auca.auca_navigate.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
    // TODO: Implement student-related endpoints
    // GET, POST, PUT, DELETE for /api/students
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Student student){
        if(student !=null){
            Student std = studentService.getStudentById(student.getStudentId());
            if(std ==  null){
                studentService.saveStudent(student);
                return new ResponseEntity<>("Student Saved!", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("Student already exist",HttpStatus.FOUND);
            }
        }
        return new ResponseEntity<>("Student is null",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    // Get AllStudent
    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents(){
        return new ResponseEntity<>(studentService.allStudents(), HttpStatus.OK);
    }
    // Get Student by ID
    @GetMapping("/search_student/{id}")
    public ResponseEntity<?> findStudentById(@PathVariable ("id") int id){
        Student student = studentService.getStudentById(id);
        if(student != null){
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
        return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
    }
    // Update Student
    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student updateStudent){
        try{
            Student updatestudent = studentService.updateStudent(id, updateStudent);
            return  ResponseEntity.ok(updatestudent);
        }catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body(null);
        }catch(Exception e){
            return ResponseEntity.status(500).body(null);
        }
    }
    //delete student
    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        try{
            studentService.deleteStudent(id);
            return ResponseEntity.ok("Student deleted successfully");
        }catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch(Exception e){
            return ResponseEntity.status(500).body("An error occurred");
        }
    }
}

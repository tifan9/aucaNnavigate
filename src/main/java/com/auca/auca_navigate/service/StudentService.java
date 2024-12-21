package com.auca.auca_navigate.service;

import com.auca.auca_navigate.domain.Student;
import com.auca.auca_navigate.repository.StudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    // TODO: Implement student-related operations
    private StudentRepo studentRepo;
    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }
    public void saveStudent(Student student){
            if(student !=null){
                studentRepo.save(student);
            }
    }
    public Student getStudentById(int id){
        return studentRepo.findById(id).orElse(null);
    }
    public void deleteStudent(Student student){
        studentRepo.delete(student);
    }
    //  find student ID



    public void deleteStudent(int id){
        studentRepo.deleteById(id);
    }
    public List<Student> allStudents(){
        return studentRepo.findAll();
    }
    @Transactional
    public Student updateStudent(int id,Student updateStudent){
        Student  existingStudent = studentRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Student not found"));
        existingStudent.setFullName(updateStudent.getFullName());
        existingStudent.setEmail(updateStudent.getEmail());
        existingStudent.setPhone(updateStudent.getPhone());
        if(updateStudent.getPassword() != null && updateStudent.getPassword().isEmpty()){
            existingStudent.setPassword(updateStudent.getPassword());
        }
        return studentRepo.save(existingStudent);
    }
}

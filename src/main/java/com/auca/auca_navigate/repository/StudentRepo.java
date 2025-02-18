package com.auca.auca_navigate.repository;

import com.auca.auca_navigate.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student, Integer> {
    Optional<Student> findByStudentId(Integer studentId);}

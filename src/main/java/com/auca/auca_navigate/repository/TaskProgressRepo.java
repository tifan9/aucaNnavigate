package com.auca.auca_navigate.repository;

import com.auca.auca_navigate.domain.TaskProgress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskProgressRepo extends JpaRepository<TaskProgress, Integer> {
    TaskProgress findByStudentId(int studentId);
}

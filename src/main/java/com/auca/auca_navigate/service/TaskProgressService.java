package com.auca.auca_navigate.service;

import com.auca.auca_navigate.domain.TaskProgress;
import com.auca.auca_navigate.repository.TaskProgressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskProgressService {
    @Autowired
    private TaskProgressRepo taskProgressRepo;
    // Retrieve progress by student ID
    public Optional<TaskProgress> getProgressByStudentId(int studentId) {
        return Optional.ofNullable(taskProgressRepo.findByStudentId(studentId));
    }

    // Save or update progress
    public TaskProgress saveOrUpdateProgress(TaskProgress taskProgress) {
        return taskProgressRepo.save(taskProgress);
    }
    // update progress
    public TaskProgress updateTaskProgress(int id, TaskProgress updateTaskProgress){
        return taskProgressRepo.findById(id).map(taskProgress -> {
            taskProgress.setSchoolTour(updateTaskProgress.isSchoolTour());
            taskProgress.setAccessPolicies(updateTaskProgress.isAccessPolicies());
            taskProgress.setAccountsSetup(updateTaskProgress.isAccountsSetup());
            taskProgress.setRegistration(updateTaskProgress.isRegistration());
            return taskProgressRepo.save(taskProgress);
        }).orElseGet(() -> {
            updateTaskProgress.setId(id);
            return taskProgressRepo.save(updateTaskProgress);
        });
    }

    // Get all progress records
    public List<TaskProgress> getAllProgress() {
        return taskProgressRepo.findAll();
    }

    // Delete progress by ID
    public void deleteProgressById(int id) {
        taskProgressRepo.deleteById(id);
    }

}

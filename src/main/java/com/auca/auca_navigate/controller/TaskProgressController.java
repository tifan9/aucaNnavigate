package com.auca.auca_navigate.controller;
import com.auca.auca_navigate.domain.TaskProgress;
import com.auca.auca_navigate.dto.TaskProgressDTO;
import com.auca.auca_navigate.service.TaskProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/task-progress")
public class TaskProgressController {
    @Autowired
    private TaskProgressService taskProgressService;

    // Get progress by student ID
    @GetMapping("/student/{studentId}")
    public ResponseEntity<TaskProgress> getProgressByStudentId(@PathVariable int studentId) {
        Optional<TaskProgress> progress = taskProgressService.getProgressByStudentId(studentId);
        return progress.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Save or update progress
    @PostMapping
    public ResponseEntity<TaskProgress> saveOrUpdateProgress(@RequestBody TaskProgress taskProgress) {
        TaskProgress savedProgress = taskProgressService.saveOrUpdateProgress(taskProgress);
        return ResponseEntity.ok(savedProgress);
    }

    // Get all progress records
    @GetMapping
    public List<TaskProgressDTO> getAllProgress() {
        List<TaskProgress> taskProgressList = taskProgressService.getAllProgress();
        return taskProgressList.stream()
                .map(TaskProgressDTO::new)
                .collect(Collectors.toList());
    }
    // update the progress
    @PutMapping("/update/{id}")
    public ResponseEntity<TaskProgress> updateTaskProgress(@PathVariable int id, @RequestBody TaskProgress updateTaskProgress) {
        TaskProgress updatedProgress = taskProgressService.updateTaskProgress(id, updateTaskProgress);
        return ResponseEntity.ok(updatedProgress);
    }

    // Delete progress by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProgressById(@PathVariable int id) {
        taskProgressService.deleteProgressById(id);
        return ResponseEntity.noContent().build();
    }
}

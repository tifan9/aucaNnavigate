package com.auca.auca_navigate.controller;
import com.auca.auca_navigate.domain.Orientation;
import com.auca.auca_navigate.dto.OrientationDTO;
import com.auca.auca_navigate.service.OrientationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orientation")
@CrossOrigin(origins = "http://localhost:3000")
public class OrientationController {
    @Autowired
    private OrientationService orientationService;

    // Get progress by student ID
    @GetMapping("/student/{studentId}")
    public ResponseEntity<Orientation> getProgressByStudentId(@PathVariable int studentId) {
        Optional<Orientation> orientation = orientationService.getProgressByStudentId(studentId);
        return orientation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Save or update progress
    @PostMapping("/save_progress")
    public ResponseEntity<Orientation> saveOrUpdateProgress(@RequestBody Orientation orientation) {
        Orientation savedProgress = orientationService.saveOrUpdateProgress(orientation);
        return ResponseEntity.ok(savedProgress);
    }

    // Get all progress records
    @GetMapping("/all_progress")
    public ResponseEntity<?> getAllProgress(){
        List<Orientation> orientationList = orientationService.getAllProgress();
        if(orientationList != null){
            List<OrientationDTO> allProgress = new ArrayList<>();
            for(Orientation orientation : orientationList){
                allProgress.add(new OrientationDTO(
                        orientation.isAccessPolicies(),
                        orientation.isAccountsSetup(),
                        orientation.getOrientationId(),
                        orientation.isRegistration(),
                        orientation.isSchoolTour(),
                        orientation.getStudent().getStudentId()));
            }
            return new ResponseEntity<>(allProgress, HttpStatus.OK);

        }
        else{
            return new ResponseEntity<>("No Progress Found",HttpStatus.OK);
        }
    }

    // update the progress
    @PutMapping("/update/{id}")
    public ResponseEntity<Orientation> updateTaskProgress(@PathVariable int id, @RequestBody Orientation updateOrientation) {
        Orientation updatedProgress = orientationService.updateOrientationProgress(id, updateOrientation);
        return ResponseEntity.ok(updatedProgress);
    }

    // Delete progress by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProgressById(@PathVariable int id) {
        orientationService.deleteProgressById(id);
        return ResponseEntity.noContent().build();
    }
}

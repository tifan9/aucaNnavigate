package com.auca.auca_navigate.service;

import com.auca.auca_navigate.domain.Orientation;
import com.auca.auca_navigate.repository.OrientationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrientationService {
    @Autowired
    private OrientationRepo orientationRepo;
    // Retrieve progress by student ID
    public Optional<Orientation> getProgressByStudentId(int studentId) {
        return orientationRepo.findByStudent_StudentId(studentId);
    }

    // Save or update progress
    public Orientation saveOrUpdateProgress(Orientation orientation) {
        return orientationRepo.save(orientation);
    }
    // update progress
    public Orientation updateOrientationProgress(int orientationId, Orientation updateOrientation){
        return orientationRepo.findById(orientationId).map(orientationProgress -> {
            orientationProgress.setSchoolTour(updateOrientation.isSchoolTour());
            orientationProgress.setAccessPolicies(updateOrientation.isAccessPolicies());
            orientationProgress.setAccountsSetup(updateOrientation.isAccountsSetup());
            orientationProgress.setRegistration(updateOrientation.isRegistration());
            return orientationRepo.save(orientationProgress);
        }).orElseGet(() -> {
            updateOrientation.setOrientationId(orientationId);
            return orientationRepo.save(updateOrientation);
        });
    }

    // Get all progress records
    public List<Orientation> getAllProgress() {
        return orientationRepo.findAll();
    }

    // Delete progress by ID
    public void deleteProgressById(int orientationId) {
        orientationRepo.deleteById(orientationId);
    }

}

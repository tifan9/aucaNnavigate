package com.auca.auca_navigate.repository;

import com.auca.auca_navigate.domain.Orientation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrientationRepo extends JpaRepository<Orientation, Integer> {
    Optional<Orientation> findByStudent_StudentId(Integer studentId);
}

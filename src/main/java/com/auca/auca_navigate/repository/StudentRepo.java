package com.auca.auca_navigate.repository;

import com.auca.auca_navigate.domain.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Students, Integer> {
}

package com.auca.auca_navigate.repository;

import com.auca.auca_navigate.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepo extends JpaRepository<Event, Long> {
}

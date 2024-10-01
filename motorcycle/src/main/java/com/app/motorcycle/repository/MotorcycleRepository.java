package com.app.motorcycle.repository;

import com.app.motorcycle.model.Motorcycle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotorcycleRepository extends JpaRepository<Motorcycle, Long> {
}

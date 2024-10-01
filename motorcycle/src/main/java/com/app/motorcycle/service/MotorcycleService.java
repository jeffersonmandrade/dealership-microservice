package com.app.motorcycle.service;

import com.app.motorcycle.model.Motorcycle;

import java.util.List;
import java.util.Optional;

public interface MotorcycleService {
    Motorcycle create(Motorcycle motorcycle);
    List<Motorcycle> findAll();
    Optional<Motorcycle> findById(Long id);
    Motorcycle update(Motorcycle motorcycle);
    void delete(Long id);
}

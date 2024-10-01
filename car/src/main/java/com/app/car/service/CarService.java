package com.app.car.service;

import com.app.car.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {
    Car create(Car car);
    List<Car> findAll();
    Optional<Car> findById(Long id);
    Car update(Car car);
    void delete(Long id);
}

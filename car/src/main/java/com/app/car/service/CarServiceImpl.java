package com.app.car.service;

import com.app.car.model.Car;
import com.app.car.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    public Car create(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> findById(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public Car update(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void delete(Long id) {
        carRepository.deleteById(id);
    }
}

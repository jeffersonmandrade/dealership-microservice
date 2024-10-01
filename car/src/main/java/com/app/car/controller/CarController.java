package com.app.car.controller;

import com.app.car.model.Car;
import com.app.car.service.CarService;
import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class CarController {
    private final CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = carService.findAll();
        log.info("GetAllCars", id);
        return ResponseEntity.ok(cars);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        Optional<Car> car = carService.findById(id);
        return car.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        Car createdCar = carService.create(car);
        return ResponseEntity.ok(createdCar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        Optional<Car> car = carService.findById(id);

        if (car.isPresent()) {
            carService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car carDetails) {
        Optional<Car> car = carService.findById(id);

        if (car.isPresent()) {
            Car carToUpdate = car.get();
            carToUpdate.setBrand(carDetails.getBrand());
            carToUpdate.setModel(carDetails.getModel());
            carToUpdate.setYear(carDetails.getYear());
            carToUpdate.setColor(carDetails.getColor());
            carToUpdate.setUsed(carDetails.isUsed());
            carToUpdate.setMileage(carDetails.getMileage());
            carToUpdate.setPrice(carDetails.getPrice());
            Car updatedCar = carService.update(carToUpdate);
            return new ResponseEntity<>(updatedCar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

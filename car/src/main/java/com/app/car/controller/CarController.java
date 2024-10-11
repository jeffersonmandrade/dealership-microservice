package com.app.car.controller;

import com.app.car.model.Car;
import com.app.car.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Car API", description = "Operations related to car management") // Tag do Swagger
public class CarController {
    private final CarService carService;

    @GetMapping
    @Operation(summary = "Get all cars", description = "Returns a list of all cars")
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = carService.findAll();
        log.info("GetAllCars");
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get car by ID", description = "Returns a car given its ID")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        Optional<Car> car = carService.findById(id);
        return car.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create a new car", description = "Adds a new car to the system")
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        Car createdCar = carService.create(car);
        return ResponseEntity.ok(createdCar);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete car by ID", description = "Deletes a car given its ID")
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
    @Operation(summary = "Update car by ID", description = "Updates the details of an existing car")
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

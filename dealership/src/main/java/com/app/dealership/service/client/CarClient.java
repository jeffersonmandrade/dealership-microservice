package com.app.dealership.service.client;

import com.app.dealership.model.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("CAR-SERVICE")
public interface CarClient {

   @GetMapping("/")
    ResponseEntity<List<Car>>getAllCars();

    @GetMapping("/{id}")
    ResponseEntity<Car> getCarById(@PathVariable("id") Long id);

    @PostMapping
    ResponseEntity<Car> createCar(@RequestBody Car car);

    @PutMapping("/{id}")
    ResponseEntity<Car> updateCar(@PathVariable("id") Long id, @RequestBody Car car);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteCar(@PathVariable("id") Long id);

}

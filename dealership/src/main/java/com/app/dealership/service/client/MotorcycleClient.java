package com.app.dealership.service.client;

import com.app.dealership.model.Motorcycle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("MOTORCYCLE-SERVICE")
public interface MotorcycleClient {

   @GetMapping("/")
    ResponseEntity<List<Motorcycle>> getAllMotorcycles();

    @GetMapping("/{id}")
    ResponseEntity<Motorcycle> getMotorcyclesById(@PathVariable("id") Long id);

    @PostMapping
    ResponseEntity<Motorcycle> createMotorcycles(@RequestBody Motorcycle motorCycle);

    @PutMapping("/{id}")
    ResponseEntity<Motorcycle> updateMotorcycles(@PathVariable("id") Long id, @RequestBody Motorcycle motorCycleDetails);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteMotorcycles(@PathVariable("id") Long id);

}

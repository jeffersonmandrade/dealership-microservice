package com.app.motorcycle.controller;

import com.app.motorcycle.model.Motorcycle;
import com.app.motorcycle.service.MotorcycleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class MotorcycleController {

    private final MotorcycleService motorcycleService;

    @GetMapping
    public ResponseEntity<List<Motorcycle>> getAllMotorcycles() {
        List<Motorcycle> motorcycles = motorcycleService.findAll();
        return ResponseEntity.ok(motorcycles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Motorcycle> getMotorcycleById(@PathVariable Long id) {
        Optional<Motorcycle> motorcycle = motorcycleService.findById(id);
        return motorcycle.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Motorcycle> createMotorcycle(@RequestBody Motorcycle motorcycle) {
        Motorcycle createdMotorcycle = motorcycleService.create(motorcycle);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMotorcycle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Motorcycle> updateMotorcycle(@PathVariable Long id, @RequestBody Motorcycle motorcycleDetails) {
        Optional<Motorcycle> motorcycle = motorcycleService.findById(id);

        if (motorcycle.isPresent()) {
            Motorcycle updatedMotorcycle = motorcycle.get();
            updatedMotorcycle.setAbs(motorcycleDetails.isAbs());
            updatedMotorcycle.setUsed(motorcycleDetails.isUsed());
            updatedMotorcycle.setType(motorcycleDetails.getType());
            updatedMotorcycle.setEngineCapacity(motorcycleDetails.getEngineCapacity());
            updatedMotorcycle.setStartType(motorcycleDetails.getStartType());
            updatedMotorcycle.setKilometersDriven(motorcycleDetails.getKilometersDriven());
            updatedMotorcycle.setTopSpeed(motorcycleDetails.getTopSpeed());
            updatedMotorcycle.setPrice(motorcycleDetails.getPrice());
            motorcycleService.update(updatedMotorcycle);
            return ResponseEntity.ok(updatedMotorcycle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMotorcycle(@PathVariable Long id) {
        motorcycleService.delete(id);
        return ResponseEntity.noContent().build();
    }


}

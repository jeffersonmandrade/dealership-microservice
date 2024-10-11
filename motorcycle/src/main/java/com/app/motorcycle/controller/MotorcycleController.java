package com.app.motorcycle.controller;

import com.app.motorcycle.model.Motorcycle;
import com.app.motorcycle.service.MotorcycleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/motorcycles")
@RequiredArgsConstructor
public class MotorcycleController {

    private final MotorcycleService motorcycleService;

    @Operation(summary = "Obter todas as motocicletas")
    @ApiResponse(responseCode = "200", description = "Lista de motocicletas retornada com sucesso")
    @GetMapping
    public ResponseEntity<List<Motorcycle>> getAllMotorcycles() {
        List<Motorcycle> motorcycles = motorcycleService.findAll();
        return ResponseEntity.ok(motorcycles);
    }

    @Operation(summary = "Obter motocicleta por ID")
    @ApiResponse(responseCode = "200", description = "Motocicleta encontrada")
    @ApiResponse(responseCode = "404", description = "Motocicleta não encontrada")
    @GetMapping("/{id}")
    public ResponseEntity<Motorcycle> getMotorcycleById(@PathVariable Long id) {
        Optional<Motorcycle> motorcycle = motorcycleService.findById(id);
        return motorcycle.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Criar nova motocicleta")
    @ApiResponse(responseCode = "201", description = "Motocicleta criada com sucesso")
    @PostMapping
    public ResponseEntity<Motorcycle> createMotorcycle(@RequestBody Motorcycle motorcycle) {
        Motorcycle createdMotorcycle = motorcycleService.create(motorcycle);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMotorcycle);
    }

    @Operation(summary = "Atualizar motocicleta existente")
    @ApiResponse(responseCode = "200", description = "Motocicleta atualizada com sucesso")
    @ApiResponse(responseCode = "404", description = "Motocicleta não encontrada")
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

    @Operation(summary = "Deletar motocicleta por ID")
    @ApiResponse(responseCode = "204", description = "Motocicleta deletada com sucesso")
    @ApiResponse(responseCode = "404", description = "Motocicleta não encontrada")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMotorcycle(@PathVariable Long id) {
        if (motorcycleService.findById(id).isPresent()) {
            motorcycleService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

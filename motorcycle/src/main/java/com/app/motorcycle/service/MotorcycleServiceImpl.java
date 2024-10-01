package com.app.motorcycle.service;

import com.app.motorcycle.model.Motorcycle;
import com.app.motorcycle.repository.MotorcycleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MotorcycleServiceImpl implements MotorcycleService {

    private final MotorcycleRepository motorcycleRepository;

    @Override
    public Motorcycle create(Motorcycle motorcycle) {
        return motorcycleRepository.save(motorcycle);
    }

    @Override
    public List<Motorcycle> findAll() {
        return motorcycleRepository.findAll();
    }

    @Override
    public Optional<Motorcycle> findById(Long id) {
        return motorcycleRepository.findById(id);
    }

    @Override
    public Motorcycle update(Motorcycle motorcycle) {
        return motorcycleRepository.save(motorcycle);
    }

    @Override
    public void delete(Long id) {
        motorcycleRepository.deleteById(id);
    }
}

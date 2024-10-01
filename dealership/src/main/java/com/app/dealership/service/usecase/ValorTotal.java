package com.app.dealership.service.usecase;

import com.app.dealership.model.Car;
import com.app.dealership.model.Motorcycle;
import com.app.dealership.service.client.CarClient;
import com.app.dealership.service.client.MotorcycleClient;
import com.app.dealership.service.usecase.output.TotalVehicleOutput;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ValorTotal {

    private final CarClient carClient;

    private final MotorcycleClient motorcycleClient;



    @CircuitBreaker(name= "valorTotal", fallbackMethod = "fallbackOutput" )
    public TotalVehicleOutput getTotalVehicle(){

        List<Motorcycle> motorcycles = motorcycleClient.getAllMotorcycles().getBody();

        List<Car> cars = carClient.getAllCars().getBody();


        BigDecimal totalValue = BigDecimal.ZERO;
        int vehicleCount = 0;

        if (cars != null) {
            for (Car car : cars) {
                totalValue = totalValue.add(car.getPrice());
            }
            vehicleCount += cars.size();
        }

        if (motorcycles != null) {
            for (Motorcycle motorcycle : motorcycles) {
                totalValue = totalValue.add(motorcycle.getPrice());
            }
            vehicleCount += motorcycles.size();
        }

        return new TotalVehicleOutput(totalValue, vehicleCount);

    }

    private TotalVehicleOutput fallbackOutput(Throwable e) {
        log.info(e.getMessage());
        return new TotalVehicleOutput(BigDecimal.ZERO, 0);
    }
}

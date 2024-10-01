package com.app.dealership.controller;

import com.app.dealership.model.Invoice;
import com.app.dealership.service.usecase.NotaFiscalUseCase;
import com.app.dealership.service.usecase.ValorTotal;
import com.app.dealership.service.usecase.output.TotalVehicleOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class DealershipController {
    private final ValorTotal valorTotal;
    private final NotaFiscalUseCase notaFiscalUseCase;

    @GetMapping("valor-total")
    public ResponseEntity<TotalVehicleOutput> getAllCars() {
        return ResponseEntity.ok(valorTotal.getTotalVehicle());
    }


    @PostMapping("nota-fiscal")
    public ResponseEntity<?> gerarNota(@RequestBody Invoice invoice) {
        notaFiscalUseCase.sendNota(invoice);
        return ResponseEntity.ok().build();
    }

}

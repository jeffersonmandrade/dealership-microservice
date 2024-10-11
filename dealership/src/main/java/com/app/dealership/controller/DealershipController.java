package com.app.dealership.controller;

import com.app.dealership.model.Invoice;
import com.app.dealership.service.usecase.NotaFiscalUseCase;
import com.app.dealership.service.usecase.ValorTotal;
import com.app.dealership.service.usecase.output.TotalVehicleOutput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor

public class DealershipController {
    private final ValorTotal valorTotal;
    private final NotaFiscalUseCase notaFiscalUseCase;

    @Operation(summary = "Obter o valor total dos veículos")
    @GetMapping("valor-total")
    public ResponseEntity<TotalVehicleOutput> getAllCars() {
        return ResponseEntity.ok(valorTotal.getTotalVehicle());
    }



    @Operation(summary = "Gerar uma nota fiscal")
    @ApiResponse(responseCode = "200", description = "Nota fiscal gerada com sucesso")
    @PostMapping("nota-fiscal")
    public ResponseEntity<?> gerarNota(@RequestBody Invoice invoice) {
        notaFiscalUseCase.sendNota(invoice);
        return ResponseEntity.ok().build();
    }

}

package com.edutech.edutech.pago.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.edutech.pago.model.Pago;
import com.edutech.edutech.pago.service.PagoService;

@RestController
@RequestMapping("/pagos")
public class PagoController {
    
    @Autowired
    private PagoService pagoService;

    // Almacenar un pago
    @PostMapping
    public String almacenarPago(@RequestBody Pago pago) {
        return pagoService.almacenar(pago);
    }

    // Listar todos los pagos
    @GetMapping
    public List<Pago> listarPagos() {
        return pagoService.listar();
    }
}

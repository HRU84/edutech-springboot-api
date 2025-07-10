package com.edutech.edutech.pago.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.edutech.pago.dto.TarjetaDTO;
import com.edutech.edutech.pago.model.Tarjeta;
import com.edutech.edutech.pago.service.TarjetaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/tarjetas")
public class TarjetaController {

    @Autowired
    private TarjetaService tarjetaService;

    //almacenar una tarjeta
    @PostMapping
    public String almacenarTarjeta(@RequestBody Tarjeta tarjeta) {
        return tarjetaService.almacenar(tarjeta);
    }
    

    //listar todas las tarjetas
    @GetMapping
    public List<TarjetaDTO> listarTarjetas() {
        return tarjetaService.listarTarjetas();
    }

    //eliminar una tarjeta
    @DeleteMapping("/{id}")
    public String eliminarTarjeta(@PathVariable int id) {
        return tarjetaService.eliminarTarjeta(id);
    }
}

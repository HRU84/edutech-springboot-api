package com.edutech.edutech.valoracion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.edutech.edutech.valoracion.model.Valoracion;
import com.edutech.edutech.valoracion.service.ValoracionService;

@RestController
@RequestMapping("/valoraciones")
public class ValoracionController {

    @Autowired
    private ValoracionService valoracionService;

    // Almacenar una valoración
    @PostMapping
    public String almacenar(@RequestBody Valoracion valoracion) {
        return valoracionService.almacenar(valoracion);
    }
    
    // Obtener todas las valoraciones
    @GetMapping
    public List<Valoracion> listar() {
        return valoracionService.listar();
    }

    // Eliminar una valoración por su id
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return valoracionService.eliminar(id);
    }

}


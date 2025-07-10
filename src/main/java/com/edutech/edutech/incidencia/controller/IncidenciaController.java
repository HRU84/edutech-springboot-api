package com.edutech.edutech.incidencia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.edutech.edutech.incidencia.model.Incidencia;
import com.edutech.edutech.incidencia.service.IncidenciaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/incidencias")
public class IncidenciaController {

    @Autowired
    private IncidenciaService incidenciaService;
    


    // Almacenar una incidencia
    @PostMapping
    public String almacenar(@RequestBody Incidencia incidencia) {
        return incidenciaService.almacenar(incidencia);
    }

    // Obtener todas las incidencias
    @GetMapping
    public List <Incidencia> listar() {
        return incidenciaService.listar();
    }
    
    // Actualizar una incidencia
    @PutMapping("/{id}") //si es necesaria la ruta
    public String actualizar(@PathVariable Integer id,@RequestBody Incidencia incidencia) {
        
        incidencia.setId(id);
        return incidenciaService.actualizar(incidencia);
    }

    // Eliminar una incidencia
    @DeleteMapping("/{id}") 
    public String eliminar(@PathVariable Integer id) {
        return incidenciaService.eliminar(id);
    }

}

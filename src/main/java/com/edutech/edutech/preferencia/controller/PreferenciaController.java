package com.edutech.edutech.preferencia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.edutech.preferencia.model.Preferencia;
import com.edutech.edutech.preferencia.service.PreferenciaService;


@RestController
@RequestMapping("/preferencias")
public class PreferenciaController {

    @Autowired
    private PreferenciaService preferenciaService;

    // Crear preferencia
    @PostMapping
    public String crear(@RequestBody Preferencia preferencia) {
        return preferenciaService.almacenar(preferencia);
    }

    // Listar preferencias
    @GetMapping
    public List<Preferencia> listar() {
        return preferenciaService.listar();
    }

    // Actualizar preferencia por descripcion
    @PutMapping("/{descripcion}")
    public String actualizar(@PathVariable String descripcion, @RequestBody Preferencia preferencia) {
        return preferenciaService.actualizar(descripcion, preferencia);
    }

    // Eliminar preferencia por descripcion
    @DeleteMapping("/{descripcion}")
    public String eliminar(@PathVariable String descripcion) {
        return preferenciaService.eliminar(descripcion);
    }
}
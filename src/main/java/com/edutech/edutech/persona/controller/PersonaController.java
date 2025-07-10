package com.edutech.edutech.persona.controller;

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

import com.edutech.edutech.persona.model.Persona;
import com.edutech.edutech.persona.service.PersonaService;


@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    // Crear persona
    @PostMapping
    public String crear(@RequestBody Persona persona) {
        return personaService.almacenar(persona);
    }

    // Listar personas
    @GetMapping
    public List<Persona> listar() {
        return personaService.listar();
    }

    // Actualizar persona
    @PutMapping("/{rut}")
    public String actualizar(@PathVariable String rut, @RequestBody Persona persona) {
        return personaService.actualizar(rut, persona);
    }

    // Eliminar persona
    @DeleteMapping("/{rut}")
    public String eliminar(@PathVariable String rut) {
        return personaService.eliminar(rut);
    }
}

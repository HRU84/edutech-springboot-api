package com.edutech.edutech.perfil.controller;

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

import com.edutech.edutech.perfil.model.Perfil;
import com.edutech.edutech.perfil.service.PerfilService;


@RestController
@RequestMapping("/perfiles")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    // Crear perfil
    @PostMapping
    public String crear(@RequestBody Perfil perfil) {
        return perfilService.almacenar(perfil);
    }

    // Listar perfiles
    @GetMapping
    public List<Perfil> listar() {
        return perfilService.listar();
    }

    // Actualizar perfil por tag
    @PutMapping("/tag/{tag}")
    public String actualizar(@PathVariable String tag, @RequestBody Perfil perfil) {
        return perfilService.actualizar(tag, perfil);
    }

    // Actualizar perfil por nombre
    @PutMapping("/nombre/{nombre}")
    public String actualizarPorNombre(@PathVariable String nombre, @RequestBody Perfil perfil) {
        return perfilService.actualizarPorNombre(nombre, perfil);
    }

    // Eliminar perfil por tag
    @DeleteMapping("/tag/{tag}")
    public String eliminar(@PathVariable String tag) {
        return perfilService.eliminar(tag);
    }

    // Eliminar perfil por nombre
    @DeleteMapping("/nombre/{nombre}")
    public String eliminarPorNombre(@PathVariable String nombre) {
        return perfilService.eliminarPorNombre(nombre);
    }
}
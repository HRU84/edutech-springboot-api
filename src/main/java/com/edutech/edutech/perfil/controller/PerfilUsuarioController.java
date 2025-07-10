package com.edutech.edutech.perfil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.edutech.perfil.model.PerfilUsuario;
import com.edutech.edutech.perfil.service.PerfilUsuarioService;



@RestController
@RequestMapping("/perfil-usuario")
public class PerfilUsuarioController {

    @Autowired
    private PerfilUsuarioService perfilUsuarioService;

    // Crear PerfilUsuario
    @PostMapping
    public String almacenar(@RequestBody PerfilUsuario perfilUsuario) {
        return perfilUsuarioService.almacenar(perfilUsuario);
    }

    // Listar todos
    @GetMapping
    public List<PerfilUsuario> listar() {
        return perfilUsuarioService.listar();
    }

    // Eliminar PerfilUsuario por mail de usuario
    @DeleteMapping("/usuario/{mail}")
    public String eliminarPorUsuario(@PathVariable String mail) {
        return perfilUsuarioService.eliminarPorUsuario(mail);
    }

    // Eliminar PerfilUsuario por tag de perfil
    @DeleteMapping("/perfil/{tag}")
    public String eliminarPorPerfil(@PathVariable String tag) {
        return perfilUsuarioService.eliminarPorPerfil(tag);
    }
}
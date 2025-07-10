package com.edutech.edutech.usuario.controller;

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

import com.edutech.edutech.usuario.dto.UsuarioDTO;
import com.edutech.edutech.usuario.model.Usuario;
import com.edutech.edutech.usuario.service.UsuarioService;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Crear usuario
    @PostMapping
    public String crear(@RequestBody Usuario usuario) {
        return usuarioService.almacenar(usuario);
    }

    // Listar usuarios (sin mostrar contraseña)
    @GetMapping
    public List<UsuarioDTO> listar() {
        return usuarioService.listar();
    }

    // Actualizar usuario
    @PutMapping("/{mail}")
    public String actualizar(@PathVariable String mail, @RequestBody Usuario usuario) {
        return usuarioService.actualizar(mail, usuario);
    }

    // Eliminar usuario
    @DeleteMapping("/{mail}")
    public String eliminar(@PathVariable String mail) {
        return usuarioService.eliminar(mail);
    }
}
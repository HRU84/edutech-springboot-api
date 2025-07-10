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

import com.edutech.edutech.usuario.model.UsuarioPreferencia;
import com.edutech.edutech.usuario.service.UsuarioPreferenciaService;



@RestController
@RequestMapping("/usuario-preferencia")
public class UsuarioPreferenciaController {

    @Autowired
    private UsuarioPreferenciaService usuarioPreferenciaService;

    // Crear UsuarioPreferencia
    @PostMapping
    public String almacenar(@RequestBody UsuarioPreferencia usuarioPreferencia) {
        return usuarioPreferenciaService.almacenar(usuarioPreferencia);
    }

    // Listar todas
    @GetMapping
    public List<UsuarioPreferencia> listar() {
        return usuarioPreferenciaService.listar();
    }

    @PutMapping("/actualizar")
    public String actualizar(@RequestBody UsuarioPreferencia usuarioPreferencia) {
        return usuarioPreferenciaService.actualizar(usuarioPreferencia);
    }
    // Eliminar por mail de usuario
    @DeleteMapping("/usuario/{mail}")
    public String eliminarPorUsuario(@PathVariable String mail) {
        return usuarioPreferenciaService.eliminarPorUsuario(mail);
    }

    // Eliminar por id de preferencia
    @DeleteMapping("/preferencia/{preferenciaId}")
    public String eliminarPorPreferencia(@PathVariable Long preferenciaId) {
        return usuarioPreferenciaService.eliminarPorPreferencia(preferenciaId);
    }

    // Eliminar por id de usuario-preferencia
    @DeleteMapping("/{id}")
    public String eliminarPorId(@PathVariable Long id) {
        return usuarioPreferenciaService.eliminarPorId(id);
    }
}

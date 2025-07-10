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

import com.edutech.edutech.usuario.model.UsuarioCurso;
import com.edutech.edutech.usuario.service.UsuarioCursoService;



@RestController
@RequestMapping("/usuario-curso")
public class UsuarioCursoController {

     @Autowired
    private UsuarioCursoService usuarioCursoService;

    // Crear UsuarioCurso
    @PostMapping
    public String almacenar(@RequestBody UsuarioCurso usuarioCurso) {
        return usuarioCursoService.almacenar(usuarioCurso);
    }

    // Listar todos los UsuarioCurso
    @GetMapping
    public List<UsuarioCurso> listar() {
        return usuarioCursoService.listar();
    }

    // Actualizar el curso 
    @PutMapping("/actualizar-curso")
    public String actualizarCurso(@RequestBody UsuarioCurso usuarioCurso) {
        return usuarioCursoService.actualizarCurso(usuarioCurso);
    }

    // Eliminar relación UsuarioCurso por mail y sigla
    @DeleteMapping("/{mail}/{sigla}")
    public String eliminar(@PathVariable String mail, @PathVariable String sigla) {
        return usuarioCursoService.eliminar(mail, sigla);
    }
    
}
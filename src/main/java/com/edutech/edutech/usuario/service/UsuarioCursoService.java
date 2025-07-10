package com.edutech.edutech.usuario.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.edutech.curso.model.Curso;
import com.edutech.edutech.curso.repository.CursoRepository;
import com.edutech.edutech.usuario.model.Usuario;
import com.edutech.edutech.usuario.model.UsuarioCurso;
import com.edutech.edutech.usuario.repository.UsuarioCursoRepository;
import com.edutech.edutech.usuario.repository.UsuarioRepository;



@Service

public class UsuarioCursoService {

    @Autowired
    private UsuarioCursoRepository usuarioCursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    // Almacenar UsuarioCurso
    public String almacenar(UsuarioCurso usuarioCurso) {
        // Validar que usuario y curso no sean null y tengan sus claves
        if (usuarioCurso.getUsuario() == null || usuarioCurso.getUsuario().getMail() == null) {
            return "Error: Debes ingresar un mail de usuario válido";
        }
        if (usuarioCurso.getCurso() == null || usuarioCurso.getCurso().getSigla() == null) {
            return "Error: Debes ingresar una sigla de curso válida";
        }

        // Verificar existencia de usuario y curso en la base de datos
        Usuario usuario = usuarioRepository.findById(usuarioCurso.getUsuario().getMail()).orElse(null);
        Curso curso = cursoRepository.findById(usuarioCurso.getCurso().getSigla()).orElse(null);

        if (usuario == null) {
            return "Error: El usuario no existe";
        }
        if (curso == null) {
            return "Error: El curso no existe";
        }

        // Verifica si ya existe la relación
        List<UsuarioCurso> existentes = usuarioCursoRepository.findByUsuario_Mail(usuarioCurso.getUsuario().getMail())
            .stream()
            .filter(uc -> uc.getCurso().getSigla().equals(usuarioCurso.getCurso().getSigla()))
            .toList();

        if (existentes.isEmpty()) {
            usuarioCurso.setUsuario(usuario);
            usuarioCurso.setCurso(curso);
            usuarioCursoRepository.save(usuarioCurso);
            return "Almacenado correctamente";
        }
        return "Error: ya existe";
    }

    // Listar todo
    public List<UsuarioCurso> listar() {
        return usuarioCursoRepository.findAll();
    }

    public String actualizarCurso(UsuarioCurso usuarioCurso) {
        // Validar que el id esté presente
        if (usuarioCurso.getId() == null) {
            return "Error: Debes ingresar el id de la relación UsuarioCurso";
        }
        // Validar que el mail sea válido
        if (usuarioCurso.getUsuario() == null || usuarioCurso.getUsuario().getMail() == null || usuarioCurso.getUsuario().getMail().trim().isEmpty()) {
            return "Error: Debes ingresar un mail de usuario válido";
        }
        // Validar que el curso esté presente
        if (usuarioCurso.getCurso() == null || usuarioCurso.getCurso().getSigla() == null) {
            return "Error: Debes ingresar una sigla de curso válida";
        }

        // Buscar la relación existente por id
        UsuarioCurso relacion = usuarioCursoRepository.findById(usuarioCurso.getId()).orElse(null);
        if (relacion == null) {
            return "No existe la relación UsuarioCurso con ese id";
        }

        // Verificar que el nuevo curso exista
        Curso nuevoCurso = cursoRepository.findById(usuarioCurso.getCurso().getSigla()).orElse(null);
        if (nuevoCurso == null) {
            return "El curso no existe";
        }

        // Actualizar el curso en la relación encontrada
        relacion.setCurso(nuevoCurso);
        usuarioCursoRepository.save(relacion);

        return "Curso actualizado correctamente";
    }


    // Eliminar relación UsuarioCurso por mail y sigla
    public String eliminar(String mail, String sigla) {
        List<UsuarioCurso> existentes = usuarioCursoRepository.findByUsuario_Mail(mail)
            .stream()
            .filter(uc -> uc.getCurso().getSigla().equals(sigla))
            .toList();

        if (existentes.isEmpty()) {
            return "La relación Usuario-Curso no existe";
        }
        usuarioCursoRepository.deleteAll(existentes);
        return "UsuarioCurso eliminado correctamente";
    }

}
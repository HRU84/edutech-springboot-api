package com.edutech.edutech.usuario.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.edutech.usuario.model.UsuarioCurso;

public interface UsuarioCursoRepository extends JpaRepository<UsuarioCurso, Long> {
    
    List<UsuarioCurso> findByUsuario_Mail(String mail);
    List<UsuarioCurso> findByCurso_Sigla(String sigla);
}

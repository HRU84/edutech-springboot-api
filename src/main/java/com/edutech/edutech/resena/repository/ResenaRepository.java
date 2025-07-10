package com.edutech.edutech.resena.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.edutech.resena.model.Resena;

public interface ResenaRepository extends JpaRepository<Resena, Integer> {
    
    Resena findByUsuarioCursoId(Long usuarioCursoId); 
}

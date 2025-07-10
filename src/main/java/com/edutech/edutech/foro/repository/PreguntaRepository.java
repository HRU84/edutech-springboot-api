package com.edutech.edutech.foro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.edutech.foro.model.Pregunta;

public interface PreguntaRepository extends JpaRepository<Pregunta, Integer> {
    
}

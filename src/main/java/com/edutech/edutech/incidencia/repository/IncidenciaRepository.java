package com.edutech.edutech.incidencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.edutech.incidencia.model.Incidencia;

public interface IncidenciaRepository extends JpaRepository<Incidencia, Integer> {
    

}

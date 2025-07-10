package com.edutech.edutech.preferencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.edutech.preferencia.model.Preferencia;



public interface PreferenciaRepository extends JpaRepository<Preferencia, Long> {

    boolean existsByDescripcion(String descripcion);
    Preferencia findByDescripcion(String descripcion);
}

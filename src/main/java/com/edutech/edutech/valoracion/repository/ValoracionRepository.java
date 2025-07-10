package com.edutech.edutech.valoracion.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.edutech.edutech.valoracion.model.Valoracion;

public interface ValoracionRepository extends JpaRepository<Valoracion, Integer> {
     
    Valoracion findByUsuarioCursoId (Long usuarioCursoId); 
}

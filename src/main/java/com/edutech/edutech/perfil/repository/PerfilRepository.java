package com.edutech.edutech.perfil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.edutech.perfil.model.Perfil;



public interface PerfilRepository extends JpaRepository<Perfil, String> {
    
    Perfil findByNombre(String nombre);

}

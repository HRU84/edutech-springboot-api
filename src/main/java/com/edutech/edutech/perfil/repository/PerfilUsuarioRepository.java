package com.edutech.edutech.perfil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.edutech.perfil.model.PerfilUsuario;




public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuario, Long> {

        // Buscar todos los PerfilUsuario por mail de usuario
    List<PerfilUsuario> findByUsuario_Mail(String mail);

    // Buscar todos los PerfilUsuario por tag de perfil
    List<PerfilUsuario> findByPerfil_Tag(String tag);

}

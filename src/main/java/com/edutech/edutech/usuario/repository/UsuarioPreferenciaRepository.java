package com.edutech.edutech.usuario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.edutech.usuario.model.UsuarioPreferencia;

public interface UsuarioPreferenciaRepository extends JpaRepository<UsuarioPreferencia, Long> {
        // Buscar por mail de usuario
    List<UsuarioPreferencia> findByUsuario_Mail(String mail);

    // Buscar por id de preferencia
    List<UsuarioPreferencia> findByPreferencia_Id(Long id);

}

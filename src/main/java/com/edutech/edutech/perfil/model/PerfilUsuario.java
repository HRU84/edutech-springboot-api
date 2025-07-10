package com.edutech.edutech.perfil.model;


import com.edutech.edutech.usuario.model.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class PerfilUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_mail", referencedColumnName = "mail")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "perfil_tag", referencedColumnName = "tag")
    private Perfil perfil;
    
    // Constructor vacío
    public PerfilUsuario() {
        this.id = 0L;
    }

    // Constructor con parámetros
    public PerfilUsuario(Long id) {
        this.id = id;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Perfil getPerfil() {
        return perfil;
    }
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}

package com.edutech.edutech.usuario.model;
import java.util.List;

import com.edutech.edutech.perfil.model.PerfilUsuario;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario {

    @Id
    private String mail;
    @JsonIgnore
    private String password;
    private boolean estado;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<UsuarioPreferencia> usuarioPreferencias;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PerfilUsuario> perfilUsuarios;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<UsuarioCurso> usuarioCursos;


    // Constructor vacío
    public Usuario() {
        this.mail = "";
        this.password = "";
        this.estado = false;
    }

    // Constructor con parámetros
    public Usuario(String mail, String password, boolean estado) {
        this.mail = mail;
        this.password = password;
        this.estado = estado;
    }

    // Getters y Setters
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public List<UsuarioPreferencia> getUsuarioPreferencias() {
        return usuarioPreferencias;
    }
    public void setUsuarioPreferencias(List<UsuarioPreferencia> usuarioPreferencias) {
        this.usuarioPreferencias = usuarioPreferencias;
    }
    public List<PerfilUsuario> getPerfilUsuarios() {
        return perfilUsuarios;
    }
    public void setPerfilUsuarios(List<PerfilUsuario> perfilUsuarios) {
        this.perfilUsuarios = perfilUsuarios;
    }
    public List<UsuarioCurso> getUsuarioCursos() {
        return usuarioCursos;
    }
    public void setUsuarioCursos(List<UsuarioCurso> usuarioCursos) {
        this.usuarioCursos = usuarioCursos;
    }

}





    

    




package com.edutech.edutech.preferencia.model;


import java.util.List;

import com.edutech.edutech.usuario.model.UsuarioPreferencia;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Preferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    @OneToMany(mappedBy = "preferencia", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<UsuarioPreferencia> usuarioPreferencias;

    // Constructor vacío
    public Preferencia() {
        this.id = 0L;
        this.descripcion = "";
    }

    // Constructor con parámetros
    public Preferencia(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public List<UsuarioPreferencia> getUsuarioPreferencias() {
        return usuarioPreferencias;
    }
    public void setUsuarioPreferencias(List<UsuarioPreferencia> usuarioPreferencias) {
        this.usuarioPreferencias = usuarioPreferencias;
    }
    
}

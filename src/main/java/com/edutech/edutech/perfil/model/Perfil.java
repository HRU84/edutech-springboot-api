package com.edutech.edutech.perfil.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Perfil {

    @Id
    private String tag;
    
    private String nombre;

    @OneToMany(mappedBy = "perfil", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PerfilUsuario> perfilUsuarios;

    // Constructor vacío
    public Perfil() {
        this.tag = "";
        this.nombre = "";
    }

    // Constructor con parámetros
    public Perfil(String tag, String nombre) {
        this.tag = tag;
        this.nombre = nombre;
    }

    // Getters y Setters
    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public List<PerfilUsuario> getPerfilUsuarios() {
        return perfilUsuarios;
    }
    public void setPerfilUsuarios(List<PerfilUsuario> perfilUsuarios) {
        this.perfilUsuarios = perfilUsuarios;
    }
    

    
}

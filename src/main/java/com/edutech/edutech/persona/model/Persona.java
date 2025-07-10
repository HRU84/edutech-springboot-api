package com.edutech.edutech.persona.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Persona {

    @Id
    private String rut;

    private String mail;
    private String nombre;
    private String apellido;

    // Constructor vacío
    public Persona() {
        this.rut = "";
        this.mail = "";
        this.nombre = "";
        this.apellido = "";
    }

    // Constructor con parámetros
    public Persona(String rut, String mail, String nombre, String apellido) {
        this.rut = rut;
        this.mail = mail;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // Getters y Setters
    public String getRut() {
        return rut;
    }
    public void setRut(String rut) {
        this.rut = rut;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
}

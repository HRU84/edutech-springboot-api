package com.edutech.edutech.instructor.model;

import java.util.List;

import com.edutech.edutech.curso.model.Curso_Instructor;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="instructor")

public class Instructor {
    @Id
    private String rut;
    private String mail;
    private String pass;
    private String nombre;
    private String apellido;
    private Boolean estado;

    @OneToMany(mappedBy="instructor", cascade= CascadeType.ALL, orphanRemoval=true)
    @JsonManagedReference("instructor-curso")
    private List<Curso_Instructor> curso_instructores;

    public Instructor(){
        this.rut = "";
        this.mail = "";
        this.pass = "";
        this.nombre = "";
        this.apellido = "";
        this.estado = true;
    }

    public Instructor(String rut, String mail, String pass, String nombre, String apellido, Boolean estado) {
        this.rut = rut;
        this.mail = mail;
        this.pass = pass;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
    }

    
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public List<Curso_Instructor> getCurso_instructores() {
        return curso_instructores;
    }

    public void setCurso_instructores(List<Curso_Instructor> curso_instructores) {
        this.curso_instructores = curso_instructores;
    }

    

    

    
}

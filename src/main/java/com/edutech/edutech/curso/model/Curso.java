package com.edutech.edutech.curso.model;

import java.util.ArrayList;
import java.util.List;

import com.edutech.edutech.contenido.model.Contenido;
import com.edutech.edutech.evaluacion.model.Evaluacion;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="curso")
public class Curso {
    @Id
    private String sigla;
    private String nombre;
    private String descripcion;
    private Boolean estado;
    private int valor;
    
    @OneToMany
    (mappedBy= "curso", cascade= CascadeType.ALL, orphanRemoval=true)
    @JsonManagedReference("curso-instructor")
    private List<Curso_Instructor> cursoInstructores; 

    //Asignando las evaluaciones a curso
    @OneToMany(mappedBy="curso", cascade=CascadeType.ALL, orphanRemoval=true)
    @JsonManagedReference("curso-evaluacion")
    private List<Evaluacion> evaluaciones = new ArrayList<>();

    //Relacionando contenido a curso
    @OneToMany(mappedBy="curso", cascade=CascadeType.ALL, orphanRemoval=true)
    @JsonManagedReference("curso-contenido")
    private List<Contenido> contenidos;

    public Curso (){
        this.sigla = "";
        this.nombre = "";
        this.descripcion = "";
        this.estado = true;
        this.valor = 0;
    }

    public Curso(String sigla, String nombre, String descripcion, Boolean estado, int valor) {
        this.sigla = sigla;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.valor = valor;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<Evaluacion> getEvaluaciones() {
        return evaluaciones;
    }

    public void setEvaluaciones(List<Evaluacion> evaluaciones) {
        this.evaluaciones = evaluaciones;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public List<Curso_Instructor> getCursoInstructores() {
        return cursoInstructores;
    }

    public void setCursoInstructores(List<Curso_Instructor> cursoInstructores) {
        this.cursoInstructores = cursoInstructores;
    }

    public List<Contenido> getContenidos() {
        return contenidos;
    }

    public void setContenidos(List<Contenido> contenidos) {
        this.contenidos = contenidos;
    }

    

    
}

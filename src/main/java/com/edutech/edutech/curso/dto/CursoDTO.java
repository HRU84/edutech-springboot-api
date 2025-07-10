package com.edutech.edutech.curso.dto;

public class CursoDTO {
    private String sigla;
    private String nombre;
    private String descripcion;
    private Boolean estado;
    private int valor;
    private String instructorRut;

    public CursoDTO(){
        this.sigla = "";
        this.nombre = "";
        this.descripcion = "";
        this.estado = true;
        this.valor = 0;
        this.instructorRut = "";
    }

    public CursoDTO(String descripcion, Boolean estado, String intructorRut, String nombre, String sigla, int valor) {
        this.descripcion = descripcion;
        this.estado = estado;
        this.instructorRut = intructorRut;
        this.nombre = nombre;
        this.sigla = sigla;
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

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getInstructorRut() {
        return instructorRut;
    }

    public void setInstructorRut(String instructorRut) {
        this.instructorRut = instructorRut;
    }


    
}

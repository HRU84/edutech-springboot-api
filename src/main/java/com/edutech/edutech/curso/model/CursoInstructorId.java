package com.edutech.edutech.curso.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable// indica que la clase puede ser utilizada como id en otra clase
public class CursoInstructorId implements  Serializable{ //para crear clases de clave compuestas

    private String cursoSigla;
    private String instructorRut;

    public CursoInstructorId(){

    }

    public CursoInstructorId(String cursoSigla, String instructorRut) {
        this.cursoSigla = cursoSigla;
        this.instructorRut = instructorRut;
    }

    public String getCursoSigla() {
        return cursoSigla;
    }

    public void setCursoSigla(String cursoSigla) {
        this.cursoSigla = cursoSigla;
    }

    public String getInstructorRut() {
        return instructorRut;
    }

    public void setInstructorRut(String instructorRut) {
        this.instructorRut = instructorRut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CursoInstructorId that)) return false;
        return Objects.equals(cursoSigla, that.cursoSigla) &&
            Objects.equals(instructorRut, that.instructorRut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cursoSigla, instructorRut);
    }
    
}

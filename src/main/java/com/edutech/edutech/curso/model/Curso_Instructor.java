package com.edutech.edutech.curso.model;

import com.edutech.edutech.instructor.model.Instructor;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class Curso_Instructor {

    @EmbeddedId
    private CursoInstructorId id;

    @ManyToOne
    @MapsId("cursoSigla")
    @JoinColumn(name="curso_sigla")
    @JsonBackReference("curso-instructor")
    private Curso curso;

    @ManyToOne
    @MapsId("instructorRut")
    @JoinColumn(name="instructor_rut")
    @JsonBackReference("instructor-curso")
    private Instructor instructor;

    public Curso_Instructor(){

    }

    public Curso_Instructor(Curso curso, Instructor instructor) {
    this.curso = curso;
    this.instructor = instructor;
    this.id = new CursoInstructorId(curso.getSigla(), instructor.getRut());
}

    public CursoInstructorId getId() {
        return id;
    }

    public void setId(CursoInstructorId id) {
        this.id = id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    
}

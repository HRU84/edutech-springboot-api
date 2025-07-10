package com.edutech.edutech.resultado.model;

import com.edutech.edutech.evaluacion.model.Evaluacion;
import com.edutech.edutech.usuario.model.UsuarioCurso;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Resultado_Evaluacion {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_curso_id")
    @JsonBackReference("usuario-resultado")
    private UsuarioCurso usuarioCursoId;

    @ManyToOne
    @JoinColumn(name = "evaluacion_id")
    @JsonBackReference("evaluacion-resultado")
    private Evaluacion evaluacionId;

    private Float calificacion;

    public Resultado_Evaluacion() {
        
    }

    public Resultado_Evaluacion(Long id, UsuarioCurso usuarioCursoId, Evaluacion evaluacionId, Float calificacion) {
        this.id = id;
        this.usuarioCursoId = usuarioCursoId;
        this.evaluacionId = evaluacionId;
        this.calificacion = calificacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsuarioCurso getUsuarioCursoId() {
        return usuarioCursoId;
    }

    public void setUsuarioCursoId(UsuarioCurso usuarioCursoId) {
        this.usuarioCursoId = usuarioCursoId;
    }

    public Evaluacion getEvaluacionId() {
        return evaluacionId;
    }

    public void setEvaluacionId(Evaluacion evaluacionId) {
        this.evaluacionId = evaluacionId;
    }

    public Float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Float calificacion) {
        this.calificacion = calificacion;
    }

    
}

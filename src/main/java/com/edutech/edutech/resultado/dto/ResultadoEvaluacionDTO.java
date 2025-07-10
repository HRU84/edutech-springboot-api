package com.edutech.edutech.resultado.dto;

public class ResultadoEvaluacionDTO {
    private Long usuarioCursoId;
    private Long evaluacionId;
    private Float calificacion;

    
    public Long getUsuarioCursoId() {
        return usuarioCursoId;
    }
    public void setUsuarioCursoId(Long usuarioCursoId) {
        this.usuarioCursoId = usuarioCursoId;
    }
    public Long getEvaluacionId() {
        return evaluacionId;
    }
    public void setEvaluacionId(Long evaluacionId) {
        this.evaluacionId = evaluacionId;
    }
    public Float getCalificacion() {
        return calificacion;
    }
    public void setCalificacion(Float calificacion) {
        this.calificacion = calificacion;
    }

    
}

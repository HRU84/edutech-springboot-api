package com.edutech.edutech.foro.model;

//Valentina Pino

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.edutech.edutech.usuario.model.UsuarioCurso;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 
    private String descripcion;
    @CreationTimestamp
    @Column(name = "fecha",updatable = false)
    private LocalDateTime fecha;
    

    //relacion con pregunta
    @ManyToOne
    @JoinColumn(name = "preguntaId")
    private Pregunta pregunta;

    //relacion con usuarioCurso
   @ManyToOne
   @JoinColumn(name = "usuarioCursoId")
   private UsuarioCurso usuarioCurso; 

    //Constructor vacio
    public Respuesta() {
        
        this.descripcion = "";
    }

    //Constructor con parametros
    public Respuesta(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public UsuarioCurso getUsuarioCurso() {
        return usuarioCurso;
    }

    public void setUsuarioCurso(UsuarioCurso usuarioCurso) {
        this.usuarioCurso = usuarioCurso;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    
    //No olvidar agregar los getters y setters de las relaciones
}

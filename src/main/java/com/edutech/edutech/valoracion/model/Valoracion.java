package com.edutech.edutech.valoracion.model;

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
import jakarta.persistence.OneToOne;

@Entity
public class Valoracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int puntaje;//0 a 10
    @CreationTimestamp
    @Column(name = "fecha",updatable = false)
    private LocalDateTime fecha;

    //relacionar con usuario-curso
    @OneToOne
    @JoinColumn(name = "usuarioCursoId", unique = true, nullable = false)
    private UsuarioCurso usuarioCurso;


    public Valoracion() {
 
    }

    public Valoracion(int id, int puntaje, LocalDateTime fecha, UsuarioCurso usuarioCurso) {
        this.id = id;
        this.puntaje = puntaje;
        this.fecha = fecha;
        this.usuarioCurso = usuarioCurso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public UsuarioCurso getUsuarioCurso() {
        return usuarioCurso;
    }

    public void setUsuarioCurso(UsuarioCurso usuarioCurso) {
        this.usuarioCurso = usuarioCurso;
    }

   
    
}

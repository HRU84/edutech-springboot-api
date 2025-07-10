package com.edutech.edutech.resena.model;

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
public class Resena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripcion;
    @CreationTimestamp
    @Column(name = "fecha",updatable = false)
    private LocalDateTime fecha;
    

    //relacionar con usuario-curso
    @OneToOne 
    @JoinColumn(name = "usuarioCursoId")
    private UsuarioCurso usuarioCurso;


    
    public Resena() {
        
    }

    public Resena(int id, String descripcion, LocalDateTime fecha, UsuarioCurso usuarioCurso) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.usuarioCurso = usuarioCurso;
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

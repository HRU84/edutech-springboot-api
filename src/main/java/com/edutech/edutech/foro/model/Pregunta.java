package com.edutech.edutech.foro.model;

//Valentina Pino
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.edutech.edutech.usuario.model.UsuarioCurso;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;




@Entity
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private String contenido;
    @CreationTimestamp
    @Column(name = "fecha",updatable = false)
    private LocalDateTime fecha;

    //relacion con usuarioCurso
    @ManyToOne
    @JoinColumn(name = "mail")
    private UsuarioCurso usuarioCurso; // modificar mas tarde para que funcione con la relacion usuario-curso
    
    //relacion con respuesta
    @OneToMany(mappedBy = "pregunta", cascade = CascadeType.ALL)
    @JsonBackReference
    
    private List<Respuesta> respuestas;

    public Pregunta() {
        
    }

    public Pregunta(int id, String titulo, String contenido, LocalDateTime fecha) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
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

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    
}
    
    
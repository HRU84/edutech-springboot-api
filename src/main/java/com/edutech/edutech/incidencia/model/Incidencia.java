package com.edutech.edutech.incidencia.model;

//valentina pino

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.edutech.edutech.usuario.model.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Incidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripcion;
    private String estado; //abierto, cerrado, en proceso
    private String prioridad; //alta, media, baja
    private String tipo; //tipo de incidencia
    @CreationTimestamp
    @Column(name = "fecha",updatable = false)
    private LocalDateTime fecha; //para saber cuando se creo la incidencia

    //relacionar con usuario
    @ManyToOne
    @JoinColumn(name = "usuario_mail",nullable = false)
    private Usuario usuario;
    

    public Incidencia() {
        
    }

    public Incidencia(int id, String descripcion, String estado, String prioridad, String tipo, LocalDateTime fecha) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.prioridad = prioridad;
        this.tipo = tipo;
        this.fecha = fecha;
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


    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }


    public String getPrioridad() {
        return prioridad;
    }


    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }


    public String getTipo() {
        return tipo;
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public LocalDateTime getFecha() {
        return fecha;
    }


    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }


    public Usuario getUsuario() {
        return usuario;
    }


    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    
    //No olvidar agregar el getter y setter de la relacion con usuarioCurso
}


package com.edutech.edutech.usuario.model;

import com.edutech.edutech.curso.model.Curso;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UsuarioCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_mail", referencedColumnName = "mail")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "curso_sigla", referencedColumnName = "sigla")
    private Curso curso;

    // Constructor vacío
    public UsuarioCurso() {
        this.id = 0L;
    }
    // Constructor con parámetros
    public UsuarioCurso(Long id) {
        this.id = id;
    }
    // Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Curso getCurso() {
        return curso;
    }
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    
    


}

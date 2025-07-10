package com.edutech.edutech.usuario.model;

import com.edutech.edutech.preferencia.model.Preferencia;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class UsuarioPreferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_mail", referencedColumnName = "mail")
    //@JsonIgnore
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "preferencia_id", referencedColumnName = "id")
    //@JsonIgnore
    private Preferencia preferencia;

    //Atributos explícitos
    public String getUsuarioMail() {
    return usuario != null ? usuario.getMail() : null;
    }
    public Long getPreferenciaId() {
        return preferencia != null ? preferencia.getId() : null;
    }

   // Constructor vacío
    public UsuarioPreferencia() {
        this.id = 0L;
    }

    // Constructor con parámetros
    public UsuarioPreferencia(Long id) {
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
    public Preferencia getPreferencia() {
        return preferencia;
    }
    public void setPreferencia(Preferencia preferencia) {
        this.preferencia = preferencia;
    }
    

}

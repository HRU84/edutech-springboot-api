package com.edutech.edutech.pago.model;

//Valentina Pino


import java.util.List;

import com.edutech.edutech.usuario.model.Usuario;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
public class Tarjeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String numero; // número de la tarjeta 
    private String nombreTitular;
    private String fechaExpiracion; // MM/AA
    private String cvv;
    private String tipo; // Visa, MasterCard, etc.
    private String banco; // opcional
    

    // Relación con Pago
    @OneToMany(mappedBy = "tarjeta",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Pago> pago; 

    //Relacion con Usuario
    @ManyToOne
    @JoinColumn(name = "Usuario_mail", referencedColumnName = "mail")
    private Usuario usuario; 

    public Tarjeta() {
        this.id = 0;
        this.numero = "";
        this.nombreTitular = "";
        this.fechaExpiracion = "";
        this.cvv = "";
        this.tipo = "";
        this.banco = "";
        this.pago = null;
    }

    public Tarjeta(int id, String numero, String nombreTitular, String fechaExpiracion, String cvv, String tipo, String banco) {
        this.id = id;
        this.numero = numero;
        this.nombreTitular = nombreTitular;
        this.fechaExpiracion = fechaExpiracion;
        this.cvv = cvv;
        this.tipo = tipo;
        this.banco = banco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public List<Pago> getPago() {
        return pago;
    }

    public void setPago(List<Pago> pago) {
        this.pago = pago;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }



}

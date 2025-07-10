package com.edutech.edutech.proveedor.model;
//Valentina Pino
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Proveedor {

    @Id
    private String rut;
    private String nombre;
    private String direccion;
    private String email;
    private String descripcion;

    public Proveedor() {
        
        this.rut = "";
        this.nombre = "";
        this.direccion = "";
        this.email = "";
        this.descripcion = "";
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}

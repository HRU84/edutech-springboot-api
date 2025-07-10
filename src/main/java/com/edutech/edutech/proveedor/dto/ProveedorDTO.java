package com.edutech.edutech.proveedor.dto;



public class ProveedorDTO {

    private String rut;
    private String nombre;
    private String direccion;
    private String email;
    private String descripcion;

    public ProveedorDTO() {
        this.rut = "";
        this.nombre = "";
        this.direccion = "";
        this.email = "";
        this.descripcion = "";
    }

    public ProveedorDTO(String rut, String nombre, String direccion, String email, String descripcion) {
        this.rut = rut;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.descripcion = descripcion;
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

package com.edutech.edutech.pago.dto;


public class TarjetaDTO {

    private int id;
    private String nombreTitular;
    private String tipo;
    private String banco;


    public TarjetaDTO() {
        this.id = 0;
        this.nombreTitular = "";
        this.tipo = "";
        this.banco = "";
    }


    public TarjetaDTO(int id, String nombreTitular, String tipo, String banco) {
        this.id = id;
        this.nombreTitular = nombreTitular;
        this.tipo = tipo;
        this.banco = banco;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getNombreTitular() {
        return nombreTitular;
    }


    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
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

    

    
}

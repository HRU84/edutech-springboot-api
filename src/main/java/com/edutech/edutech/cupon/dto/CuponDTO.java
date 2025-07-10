package com.edutech.edutech.cupon.dto;


public class CuponDTO {
    
    private String codigo;

    
    private int porcentaje_descuento; 

    public CuponDTO (){

    }

    public CuponDTO(String codigo, int porcentaje_descuento) {
        this.codigo = codigo;
        this.porcentaje_descuento = porcentaje_descuento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getPorcentaje_descuento() {
        return porcentaje_descuento;
    }

    public void setPorcentaje_descuento(int porcentaje_descuento) {
        this.porcentaje_descuento = porcentaje_descuento;
    }

    
}


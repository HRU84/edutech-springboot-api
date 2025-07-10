package com.edutech.edutech.shared.model;

public class ApiResponse<T> {
    private String mensaje;
    private String estado;
    private T data;

    public ApiResponse(){

    }

    public ApiResponse(String mensaje, String estado, T data) {
        this.mensaje = mensaje;
        this.estado = estado;
        this.data = data;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    
}

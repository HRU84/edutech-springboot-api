package com.edutech.edutech.usuario.dto;

public class UsuarioDTO {

    private String mail;
    private boolean estado;

    // Constructor vacío
    public UsuarioDTO() {
        this.mail = "";
        this.estado = false;
    }

    // Constructor con parámetros
    public UsuarioDTO(String mail, boolean estado) {
        this.mail = mail;
        this.estado = estado;
    }

    // Getters y Setters
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }    


}

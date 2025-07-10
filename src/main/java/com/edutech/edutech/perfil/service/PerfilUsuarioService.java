package com.edutech.edutech.perfil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.edutech.perfil.model.Perfil;
import com.edutech.edutech.perfil.model.PerfilUsuario;
import com.edutech.edutech.perfil.repository.PerfilRepository;
import com.edutech.edutech.perfil.repository.PerfilUsuarioRepository;
import com.edutech.edutech.usuario.model.Usuario;
import com.edutech.edutech.usuario.repository.UsuarioRepository;


@Service
public class PerfilUsuarioService {

    @Autowired
    private PerfilUsuarioRepository perfilUsuarioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    public String almacenar(PerfilUsuario perfilUsuario) {
        if (perfilUsuario.getUsuario() == null || perfilUsuario.getUsuario().getMail() == null) {
            return "Error: Debes ingresar un mail de usuario válido";
        }
        if (perfilUsuario.getPerfil() == null || perfilUsuario.getPerfil().getTag() == null) {
            return "Error: Debes ingresar un tag de perfil válido";
        }
        String mail = perfilUsuario.getUsuario().getMail();
        String tag = perfilUsuario.getPerfil().getTag();

        // Validar que no exista ya la relación usuario-perfil
        boolean yaExiste = perfilUsuarioRepository
            .findByUsuario_Mail(mail)
            .stream()
            .anyMatch(pu -> pu.getPerfil().getTag().equals(tag));
        if (yaExiste) {
            return "Error: Ya existe ese perfil para el usuario";
        }

        Usuario usuario = usuarioRepository.findById(mail).orElse(null);
        Perfil perfil = perfilRepository.findById(tag).orElse(null);

        if (usuario == null) {
            return "Error: El usuario no existe";
        }
        if (perfil == null) {
            return "Error: El perfil no existe";
        }
        if (!usuario.getMail().equals(mail)) {
            return "Error: El mail de PerfilUsuario y Usuario no coinciden exactamente";
        }

        if (!perfil.getTag().equals(tag)) {
            return "Error: El tag de PerfilUsuario y Perfil no coinciden exactamente";
        }
        perfilUsuario.setUsuario(usuario);
        perfilUsuario.setPerfil(perfil);

        perfilUsuarioRepository.save(perfilUsuario);
        return "PerfilUsuario almacenado correctamente";
    }

    // Listar todos
    public List<PerfilUsuario> listar() {
        return perfilUsuarioRepository.findAll();
    }

    // Eliminar por mail de usuario
    public String eliminarPorUsuario(String mail) {
        List<PerfilUsuario> existentes = perfilUsuarioRepository.findByUsuario_Mail(mail);
        if (existentes.isEmpty()) {
            return "No existen relaciones para ese usuario";
        }
        perfilUsuarioRepository.deleteAll(existentes);
        return "Relaciones eliminadas correctamente";
    }

    // Eliminar por tag de perfil
    public String eliminarPorPerfil(String tag) {
        List<PerfilUsuario> existentes = perfilUsuarioRepository.findByPerfil_Tag(tag);
        if (existentes.isEmpty()) {
            return "No existen relaciones para ese perfil";
        }
        perfilUsuarioRepository.deleteAll(existentes);
        return "Relaciones eliminadas correctamente";
    }
}
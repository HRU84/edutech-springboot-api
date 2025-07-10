package com.edutech.edutech.usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.edutech.usuario.dto.UsuarioDTO;
import com.edutech.edutech.usuario.model.Usuario;
import com.edutech.edutech.usuario.repository.UsuarioRepository;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Almacenar usuario
    public String almacenar(Usuario usuario) {
        if (!usuarioRepository.existsById(usuario.getMail())) {
            usuarioRepository.save(usuario);
            return "Usuario almacenado correctamente";
        }
        return "El usuario ya existe";
    }

    // Listar usuarios sin mostrar la contraseña
    public List<UsuarioDTO> listar() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
            .map(u -> new UsuarioDTO(u.getMail(), u.isEstado()))
            .toList();
    }

    // Actualizar usuario
    public String actualizar(String mail, Usuario usuario) {
        if (!usuarioRepository.existsById(mail)) {
            return "Error: El usuario no existe";
        }
        Usuario usuarioExistente = usuarioRepository.findById(mail).get();
        usuarioExistente.setPassword(usuario.getPassword());
        usuarioExistente.setEstado(usuario.isEstado());
        // Agrega aquí otros campos si existen

        usuarioRepository.save(usuarioExistente);
        return "Usuario actualizado correctamente";
    }

    // Eliminar usuario
    public String eliminar(String mail) {
        if (!usuarioRepository.existsById(mail)) {
            return "Error: El usuario no existe";
        }
        usuarioRepository.deleteById(mail);
        return "Usuario eliminado correctamente";
    }
}
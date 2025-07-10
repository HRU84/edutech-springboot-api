package com.edutech.edutech.usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.edutech.preferencia.model.Preferencia;
import com.edutech.edutech.preferencia.repository.PreferenciaRepository;
import com.edutech.edutech.usuario.model.Usuario;
import com.edutech.edutech.usuario.model.UsuarioPreferencia;
import com.edutech.edutech.usuario.repository.UsuarioPreferenciaRepository;
import com.edutech.edutech.usuario.repository.UsuarioRepository;

@Service
public class UsuarioPreferenciaService {

    @Autowired
    private UsuarioPreferenciaRepository usuarioPreferenciaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PreferenciaRepository preferenciaRepository;

    public String almacenar(UsuarioPreferencia usuarioPreferencia) {
        // Primero valida que los objetos no sean null
        if (usuarioPreferencia.getUsuario() == null || usuarioPreferencia.getUsuario().getMail() == null) {
            return "Error: Debes ingresar un mail válido";
        }
        if (usuarioPreferencia.getPreferencia() == null || usuarioPreferencia.getPreferencia().getId() == null) {
            return "Error: Debes ingresar una preferencia válida";
        }

        String mail = usuarioPreferencia.getUsuario().getMail();
        Long preferenciaId = usuarioPreferencia.getPreferencia().getId();

        // Validar que no exista ya la relación usuario-preferencia
        boolean yaExiste = usuarioPreferenciaRepository
            .findByUsuario_Mail(mail)
            .stream()
            .anyMatch(up -> up.getPreferencia().getId().equals(preferenciaId));
        if (yaExiste) {
            return "Error: Ya existe esa preferencia para el usuario";
        }

        Usuario usuario = usuarioRepository.findById(mail).orElse(null);
        Preferencia preferencia = preferenciaRepository.findById(preferenciaId).orElse(null);

        if (usuario == null) {
            return "Error: El usuario no existe";
        }
        if (preferencia == null) {
            return "Error: La preferencia no existe";
        }

        usuarioPreferencia.setUsuario(usuario);
        usuarioPreferencia.setPreferencia(preferencia);
        usuarioPreferenciaRepository.save(usuarioPreferencia);
        return "UsuarioPreferencia almacenada correctamente";
    }

    // Listar todas
    public List<UsuarioPreferencia> listar() {
        return usuarioPreferenciaRepository.findAll();
    }

    public String actualizar(UsuarioPreferencia usuarioPreferencia) {
        // Validar que el id esté presente
        if (usuarioPreferencia.getId() == null) {
            return "Error: Debes ingresar el id de la relación UsuarioPreferencia";
        }
        // Validar que el mail sea válido
        if (usuarioPreferencia.getUsuario() == null || usuarioPreferencia.getUsuario().getMail() == null || usuarioPreferencia.getUsuario().getMail().trim().isEmpty()) {
            return "Error: Debes ingresar un mail de usuario válido";
        }
        // Validar que la preferencia esté presente
        if (usuarioPreferencia.getPreferencia() == null || usuarioPreferencia.getPreferencia().getId() == null) {
            return "Error: Debes ingresar una preferencia válida";
        }

        // Buscar la relación existente por id
        UsuarioPreferencia relacion = usuarioPreferenciaRepository.findById(usuarioPreferencia.getId()).orElse(null);
        if (relacion == null) {
            return "No existe la relación UsuarioPreferencia con ese id";
        }

        // Verificar que el usuario exista
        Usuario usuario = usuarioRepository.findById(usuarioPreferencia.getUsuario().getMail()).orElse(null);
        if (usuario == null) {
            return "El usuario no existe";
        }

        // Verificar que la preferencia exista
        Preferencia preferencia = preferenciaRepository.findById(usuarioPreferencia.getPreferencia().getId()).orElse(null);
        if (preferencia == null) {
            return "La preferencia no existe";
        }

        // Actualizar la relación encontrada
        relacion.setUsuario(usuario);
        relacion.setPreferencia(preferencia);
        usuarioPreferenciaRepository.save(relacion);

        return "UsuarioPreferencia actualizada correctamente";
    }

    // Eliminar por mail de usuario
    public String eliminarPorUsuario(String mail) {
        List<UsuarioPreferencia> existentes = usuarioPreferenciaRepository.findByUsuario_Mail(mail);
        if (existentes.isEmpty()) {
            return "No existen preferencias para ese usuario";
        }
        usuarioPreferenciaRepository.deleteAll(existentes);
        return "Preferencias eliminadas correctamente";
    }

    // Eliminar por id de preferencia
    public String eliminarPorPreferencia(Long preferenciaId) {
        List<UsuarioPreferencia> existentes = usuarioPreferenciaRepository.findByPreferencia_Id(preferenciaId);
        if (existentes.isEmpty()) {
            return "No existen usuarios para esa preferencia";
        }
        usuarioPreferenciaRepository.deleteAll(existentes);
        return "Preferencias eliminadas correctamente";
    }

    // Eliminar por id de la relación
    public String eliminarPorId(Long id) {
        if (!usuarioPreferenciaRepository.existsById(id)) {
            return "La relación Usuario-Preferencia no existe";
        }
        usuarioPreferenciaRepository.deleteById(id);
        return "UsuarioPreferencia eliminada correctamente";
    }
}
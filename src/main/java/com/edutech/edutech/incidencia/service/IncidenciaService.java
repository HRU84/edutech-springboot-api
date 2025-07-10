package com.edutech.edutech.incidencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.edutech.usuario.model.Usuario;
import com.edutech.edutech.usuario.repository.UsuarioRepository;

import com.edutech.edutech.incidencia.model.Incidencia;
import com.edutech.edutech.incidencia.repository.IncidenciaRepository;

@Service
public class IncidenciaService {

    @Autowired
    private IncidenciaRepository incidenciaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    //almacenar una incidencia
    public String almacenar(Incidencia incidencia) {
        
        if (incidencia.getId() != 0 && 
            incidenciaRepository.existsById(incidencia.getId())) {
            return "Incidencia ya existe";
        }

        String mail = incidencia.getUsuario().getMail();
        Usuario usuario = usuarioRepository.findById(mail).orElse(null);
        if (usuario == null) {
            return "Usuario no encontrado, no se puede registrar la incidencia";
        }

        incidencia.setUsuario(usuario);
        incidenciaRepository.save(incidencia);
        return "Incidencia almacenada con éxito";
    }

    //obtener todas las incidencias
    public List<Incidencia> listar() {
        return incidenciaRepository.findAll();
    }

    //actualizar una incidencia 
    public String actualizar(Incidencia incidencia) {
        // Primero: la incidencia debe existir
        if (!incidenciaRepository.existsById(incidencia.getId())) {
            return "Incidencia no encontrada";
        }

        // Validamos usuario
        String mail = incidencia.getUsuario().getMail();
        Usuario usuario = usuarioRepository.findById(mail).orElse(null);
        if (usuario == null) {
            return "Usuario no encontrado. No se puede actualizar la incidencia.";
        }

        // Cargamos la existente y le copiamos los cambios
        Incidencia original = incidenciaRepository.findById(incidencia.getId()).get();
        original.setDescripcion   (incidencia.getDescripcion());
        original.setEstado        (incidencia.getEstado());
        original.setPrioridad     (incidencia.getPrioridad());
        original.setTipo          (incidencia.getTipo());
        original.setUsuario       (usuario);

        incidenciaRepository.save(original);
        return "Incidencia actualizada con éxito";
    }
        

   
    //eliminar una incidencia
    public String eliminar(int id) {
        if (incidenciaRepository.existsById(id)) {
            incidenciaRepository.deleteById(id);
            return "Incidencia eliminada con éxito";
        } else {
            return "Incidencia no encontrada";
        }
    }
    
}

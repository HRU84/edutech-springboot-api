package com.edutech.edutech.valoracion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.edutech.usuario.repository.UsuarioCursoRepository;
import com.edutech.edutech.valoracion.model.Valoracion;
import com.edutech.edutech.valoracion.repository.ValoracionRepository;


@Service
public class ValoracionService {

    @Autowired
    private ValoracionRepository valoracionRepository;

    @Autowired
    private UsuarioCursoRepository usuarioCursoRepository;
    
    
    //almacenar una valoracion
    public String almacenar(Valoracion valoracion) {
    Long usuarioCursoId = valoracion.getUsuarioCurso().getId();

        // Validar existencia de UsuarioCurso
    if (!usuarioCursoRepository.existsById(usuarioCursoId)) {
        return "No se puede almacenar: UsuarioCurso con ID " + usuarioCursoId + " no existe";
    }

        // Verificar si ya existe una valoración para ese UsuarioCurso
        Valoracion existente = valoracionRepository.findByUsuarioCursoId(usuarioCursoId);
    if (existente != null) {
        return "Ya existe una valoración para este usuario y curso";
    }

        // Guardar la valoración
        valoracionRepository.save(valoracion);
        return "Valoración almacenada con éxito";
    }


    // Listar todas las valoraciones
    public List<Valoracion> listar() {
        return valoracionRepository.findAll();
    }

    // Eliminar una valoración por su id
    public String eliminar(int id) {
        if (!valoracionRepository.existsById(id)) {
            return "Error: Valoración no encontrada con id " + id;
        }
        valoracionRepository.deleteById(id);
        return "Valoración eliminada con éxito";
    }
}

package com.edutech.edutech.resena.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.edutech.edutech.usuario.model.UsuarioCurso;
import com.edutech.edutech.usuario.repository.UsuarioCursoRepository;
import com.edutech.edutech.resena.model.Resena;
import com.edutech.edutech.resena.repository.ResenaRepository;

@Service
public class ResenaService {


    @Autowired
    private ResenaRepository resenaRepository;
    @Autowired
    private UsuarioCursoRepository usuarioCursoRepository;

    //almacenar una reseña
    public String almacenar(Resena resena) {
    Long ucId = resena.getUsuarioCurso().getId();

    // Busca el UsuarioCurso ya gestionado
    UsuarioCurso uc = usuarioCursoRepository.findById(ucId).orElseThrow(() ->
            new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "No se puede almacenar: UsuarioCurso con ID " + ucId + " no existe"
            )
        );

    // Comprueba que no haya reseña previa
    if (resenaRepository.findByUsuarioCursoId(ucId) != null) {
        return "Ya existe una reseña para este usuario y curso";
    }

    // Asocia la instancia gestionada y guarda la reseña
    resena.setUsuarioCurso(uc);
    resenaRepository.save(resena);
    return "Reseña almacenada con éxito";
}


    //obtener todas las reseñas
    public List<Resena> listar() {
        return resenaRepository.findAll();
    }


    // Eliminar una reseña por su id
    public String eliminar(int id) {
        if (!resenaRepository.existsById(id)) {
            return "Error: Reseña no encontrada con id " + id;
        }
        resenaRepository.deleteById(id);
        return "Reseña eliminada con éxito";
    }

}

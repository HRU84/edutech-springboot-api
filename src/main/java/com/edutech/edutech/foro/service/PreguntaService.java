package com.edutech.edutech.foro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.edutech.usuario.repository.UsuarioCursoRepository;
import com.edutech.edutech.foro.model.Pregunta;
import com.edutech.edutech.foro.repository.PreguntaRepository;


@Service
public class PreguntaService {

    @Autowired
    private PreguntaRepository preguntaRepository;
    @Autowired
    private UsuarioCursoRepository usuarioCursoRepository;
    
    //almacenar una pregunta
    public String almacenar(Pregunta pregunta) {
        Long usuarioCursoId = pregunta.getUsuarioCurso().getId(); // suponiendo que es Long

    if (usuarioCursoRepository.existsById(usuarioCursoId)) {
        preguntaRepository.save(pregunta);
        return "Pregunta almacenada con éxito";
    } else {
        return "No se puede almacenar la pregunta: UsuarioCurso no existe";
    }
    }

    //listar una pregunta
    public List<Pregunta> listarPreguntas() {
        return preguntaRepository.findAll();
    }

    //eliminar una pregunta
    public String eliminarPregunta(int id) {
        if (preguntaRepository.existsById(id)) {
        // Verificar si la pregunta existe
        preguntaRepository.deleteById(id);
            return "Pregunta eliminada con éxito";

        }else {
            return "Pregunta no encontrada.No se ha podido eliminar";
        }
    }

}

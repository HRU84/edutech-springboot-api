package com.edutech.edutech.foro.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edutech.edutech.usuario.repository.UsuarioCursoRepository;
import com.edutech.edutech.foro.model.Respuesta;
import com.edutech.edutech.foro.repository.PreguntaRepository;
import com.edutech.edutech.foro.repository.RespuestaRepository;

@Service
public class RespuestaService {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private PreguntaRepository preguntaRepository;

    @Autowired
    private UsuarioCursoRepository usuarioCursoRepository;

    public String almacenar(Respuesta respuesta) {
        //  Validar pregunta
        if (respuesta.getPregunta() == null || respuesta.getPregunta().getId() == 0) {
            return "Pregunta no proporcionada";
        }
        int preguntaId = respuesta.getPregunta().getId();
        if (!preguntaRepository.existsById(preguntaId)) {
            return "Pregunta no encontrada";
        }

        //  Validar usuarioCurso
        if (respuesta.getUsuarioCurso() == null || respuesta.getUsuarioCurso().getId() == 0) {
            return "UsuarioCurso no proporcionado";
        }
            Long usuarioCursoId = respuesta.getUsuarioCurso().getId();
        if (!usuarioCursoRepository.existsById(usuarioCursoId)) {
            return "UsuarioCurso no encontrado";
        }

        respuestaRepository.save(respuesta);
        return "Respuesta almacenada con éxito";
    }

    //listar  respuestas
    public List <Respuesta> listarRespuestas() {
        return respuestaRepository.findAll();
    }

    //eliminar una respuesta
    public String eliminarRespuesta(int id) {
        if (respuestaRepository.existsById(id)) {
            respuestaRepository.deleteById(id);
            return "Respuesta eliminada con éxito";
        } else {
            return "Respuesta no encontrada.No se ha podido eliminar";
        }
    }

}

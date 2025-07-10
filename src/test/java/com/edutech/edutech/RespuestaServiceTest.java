package com.edutech.edutech;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.edutech.edutech.foro.model.Pregunta;
import com.edutech.edutech.foro.model.Respuesta;
import com.edutech.edutech.foro.repository.PreguntaRepository;
import com.edutech.edutech.foro.repository.RespuestaRepository;
import com.edutech.edutech.foro.service.RespuestaService;
import com.edutech.edutech.usuario.model.UsuarioCurso;
import com.edutech.edutech.usuario.repository.UsuarioCursoRepository;

@ExtendWith(MockitoExtension.class)
public class RespuestaServiceTest {

    @Mock
    private RespuestaRepository respuestaRepository;

    @Mock
    private PreguntaRepository preguntaRepository;

    @Mock
    private UsuarioCursoRepository usuarioCursoRepository;

    @InjectMocks
    private RespuestaService respuestaService;


    @Test // almacenar una respuesta - pregunta y usuarioCurso existentes
    void almacenarRespuestaExitosa() {
        Pregunta pregunta = new Pregunta();
        pregunta.setId(1);

        UsuarioCurso usuarioCurso = new UsuarioCurso();
        usuarioCurso.setId(1L);

        Respuesta respuesta = new Respuesta();
        respuesta.setId(1);
        respuesta.setDescripcion("Mi respuesta");
        respuesta.setPregunta(pregunta);
        respuesta.setUsuarioCurso(usuarioCurso);

        when(preguntaRepository.existsById(1)).thenReturn(true);
        when(usuarioCursoRepository.existsById(1L)).thenReturn(true);

        String resultado = respuestaService.almacenar(respuesta);

        assertEquals("Respuesta almacenada con éxito", resultado);
        
    }

    @Test // almacenar una respuesta - pregunta inexistente
    void almacenarRespuestaSinPregunta() {
        Respuesta respuesta = new Respuesta();
        respuesta.setUsuarioCurso(new UsuarioCurso());

        String resultado = respuestaService.almacenar(respuesta);

        assertEquals("Pregunta no proporcionada", resultado);
        
    }

    @Test // listar respuestas
    void listarRespuestas() {
        Respuesta r1 = new Respuesta();
        r1.setId(1);
        r1.setDescripcion("Respuesta 1");

        Respuesta r2 = new Respuesta();
        r2.setId(2);
        r2.setDescripcion("Respuesta 2");

        List<Respuesta> lista = Arrays.asList(r1, r2);

        when(respuestaRepository.findAll()).thenReturn(lista);

        List<Respuesta> resultado = respuestaService.listarRespuestas();

        assertEquals(2, resultado.size());
        assertEquals("Respuesta 1", resultado.get(0).getDescripcion());
    }

    @Test // eliminar una respuesta - respuesta existente
    void eliminarRespuestaExistente() {
        when(respuestaRepository.existsById(1)).thenReturn(true);

        String resultado = respuestaService.eliminarRespuesta(1);

        assertEquals("Respuesta eliminada con éxito", resultado);
        
    }

    @Test // eliminar una respuesta - respuesta inexistente
    void eliminarRespuestaInexistente() {
        when(respuestaRepository.existsById(99)).thenReturn(false);

        String resultado = respuestaService.eliminarRespuesta(99);

        assertEquals("Respuesta no encontrada.No se ha podido eliminar", resultado);
        
    }
}

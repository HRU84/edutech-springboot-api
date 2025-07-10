package com.edutech.edutech;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.edutech.edutech.foro.model.Pregunta;
import com.edutech.edutech.foro.repository.PreguntaRepository;
import com.edutech.edutech.foro.service.PreguntaService;
import com.edutech.edutech.usuario.model.UsuarioCurso;
import com.edutech.edutech.usuario.repository.UsuarioCursoRepository;

@ExtendWith(MockitoExtension.class)
public class PreguntaServiceTest {

    @Mock
    private PreguntaRepository preguntaRepository;

    @InjectMocks
    private PreguntaService preguntaService;

    @Mock
    private UsuarioCursoRepository usuarioCursoRepository;
    

    @Test //almacenar una pregunta - usuario existente
    void almacenarPreguntaConUsuarioCursoExistente() {
        UsuarioCurso usuarioCurso = new UsuarioCurso();
        usuarioCurso.setId(1L);

        Pregunta pregunta = new Pregunta();
        pregunta.setId(100);
        pregunta.setContenido("¿Qué es Java?");
        pregunta.setUsuarioCurso(usuarioCurso);

        // Simulamos que el UsuarioCurso existe
        when(usuarioCursoRepository.existsById(1L)).thenReturn(true);

        String resultado = preguntaService.almacenar(pregunta);

        assertEquals("Pregunta almacenada con éxito", resultado);
        
    }

       
    @Test //almacenar una pregunta - usuario inexistente
    void almacenarPreguntaConUsuarioCursoInexistente() {
        UsuarioCurso usuarioCurso = new UsuarioCurso();
        usuarioCurso.setId(1L);

        Pregunta pregunta = new Pregunta();
        pregunta.setId(100);
        pregunta.setContenido("¿Qué es Java?");
        pregunta.setUsuarioCurso(usuarioCurso);

        // Simulamos que el UsuarioCurso NO existe
        when(usuarioCursoRepository.existsById(1L)).thenReturn(false);

        String resultado = preguntaService.almacenar(pregunta);

        assertEquals("No se puede almacenar la pregunta: UsuarioCurso no existe", resultado);
        
    }
   

     
    @Test //listar preguntas
    void listarPreguntas() {
        Pregunta p1 = new Pregunta();
        p1.setId(1);
        p1.setContenido("¿Qué es Java?");

        Pregunta p2 = new Pregunta();
        p2.setId(2);
        p2.setContenido("¿Qué es Spring Boot?");

        List<Pregunta> lista = new ArrayList<>();
        lista.add(p1);
        lista.add(p2);

        when(preguntaRepository.findAll()).thenReturn(lista);

        List<Pregunta> resultado = preguntaService.listarPreguntas();

        assertEquals(2, resultado.size());
        assertEquals("¿Qué es Java?", resultado.get(0).getContenido());
    }
    

     
    @Test // eliminar pregunta existente
    void eliminarPreguntaExistente() {
        int id = 10;

        when(preguntaRepository.existsById(id)).thenReturn(true);

        String resultado = preguntaService.eliminarPregunta(id);

        assertEquals("Pregunta eliminada con éxito", resultado);
        
    }

   
    @Test // eliminar pregunta inexistente
    void eliminarPreguntaInexistente() {
        int id = 99;

        when(preguntaRepository.existsById(id)).thenReturn(false);

        String resultado = preguntaService.eliminarPregunta(id);

        assertEquals("Pregunta no encontrada.No se ha podido eliminar", resultado);
        
    }

}

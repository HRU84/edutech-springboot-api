package com.edutech.edutech;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.edutech.edutech.curso.model.Curso;
import com.edutech.edutech.curso.repository.CursoRepository;
import com.edutech.edutech.evaluacion.dto.EvaluacionDTO;
import com.edutech.edutech.evaluacion.model.Evaluacion;
import com.edutech.edutech.evaluacion.repository.EvaluacionRepository;
import com.edutech.edutech.evaluacion.service.EvaluacionService;
import com.edutech.edutech.shared.model.ApiResponse;

@ExtendWith(MockitoExtension.class)
public class ContenidoServiceTest {

    @Mock
    private EvaluacionRepository evaluacionRepository;
    @Mock
    private CursoRepository cursoRepository;

    @InjectMocks
    private EvaluacionService evaluacionService;

    @Test
    @DisplayName("Debe guardar una evaluacion con los datos correctos")
    void crearEvaluacion(){

        Curso curso1 = new Curso();
        curso1.setSigla("AABB123");
        curso1.setNombre("Programacion Test ");
        curso1.setDescripcion("Curso creado para test  ");
        curso1.setEstado(false);
        curso1.setValor(6666666);

        //simulamos que el curso existe
        when(cursoRepository.findById("AABB123")).thenReturn(Optional.of(curso1));

        //DTO para la evaluacion 
        EvaluacionDTO evaluacionDTO = new EvaluacionDTO();
        evaluacionDTO.setNombre("Evalaucion test");
        evaluacionDTO.setCursoSigla("AABB123");

        //Evaluacion creada
        Evaluacion evaluacion = new Evaluacion();
        evaluacion.setNombre("Evaluacion test");
        evaluacion.setCurso(curso1);

        //simular guardado
        when (evaluacionRepository.save(any(Evaluacion.class))).thenReturn(evaluacion);

        ApiResponse<Evaluacion> resultado = 
        evaluacionService.crearEvaluacionDesdeDTO(evaluacionDTO);

        assertEquals("Evaluación creada correctamente", resultado.getMensaje());
        assertEquals("ok", resultado.getEstado());

        assertEquals("Evaluacion test", resultado.getData().getNombre());
        assertEquals("AABB123", resultado.getData().getCurso().getSigla());

    }

}

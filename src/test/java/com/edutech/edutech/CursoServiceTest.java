package com.edutech.edutech;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.edutech.edutech.curso.dto.CursoDTO;
import com.edutech.edutech.curso.model.Curso;
import com.edutech.edutech.curso.repository.CursoRepository;
import com.edutech.edutech.curso.service.CursoService;
import com.edutech.edutech.shared.model.ApiResponse;

@ExtendWith(MockitoExtension.class)
public class CursoServiceTest {

    @Mock
    private CursoRepository cursoRepository;


    @InjectMocks
    private CursoService cursoService;

    @Test
    @DisplayName("Debe crear un curso desde el DTO correctamente")
    void crearCursoDesdeDtoTest(){

        CursoDTO dto = new CursoDTO();
        dto.setSigla("AABB123");
        dto.setNombre("Programacion Test");
        dto.setDescripcion("Curso creado para test");
        dto.setEstado(true);
        dto.setValor(999999);

        Curso curso = new Curso();
        curso.setSigla(dto.getSigla());
        curso.setNombre(dto.getNombre());
        curso.setDescripcion(dto.getDescripcion());
        curso.setEstado(dto.getEstado());
        curso.setValor(dto.getValor());


        when(cursoRepository.existsById(dto.getSigla()))
        .thenReturn(false);

        //when(cursoRepository.save(any(Curso.class))).thenReturn(Curso);

        ApiResponse<Curso> resultado = cursoService.crearCursoDesdeDTO(dto);

        assertNotNull(resultado);
        assertEquals("ok", resultado.getEstado());
        assertEquals("Curso creado correctamente", resultado.getMensaje());
        
    }

    @Test
    @DisplayName("Debe actualizar correctamente")
    void actulizarCurso(){

        
        Curso curso1 = new Curso();
        curso1.setSigla("AABB123");
        curso1.setNombre("Programacion Test ");
        curso1.setDescripcion("Curso creado para test  ");
        curso1.setEstado(false);
        curso1.setValor(6666666);

        CursoDTO cursoActualizado = new CursoDTO();
        cursoActualizado.setSigla("AABB123");
        cursoActualizado.setNombre("Programacion Test actualizado");
        cursoActualizado.setDescripcion("Curso creado para test, actulizado");
        cursoActualizado.setEstado(true);
        cursoActualizado.setValor(999999);


        

        //simula que lo encuentra al buscarlo
        when(cursoRepository.findById(cursoActualizado.getSigla()))
        .thenReturn(Optional.of(curso1));

        //simula que lo guarda
        when(cursoRepository.save(any(Curso.class)))
        .thenReturn(curso1);

        ApiResponse<Curso> resultado = cursoService.actualizarCurso(cursoActualizado.getSigla(), cursoActualizado);

        assertEquals("Curso actualizado correctamente", resultado.getMensaje());
        assertEquals("ok", resultado.getEstado());
        assertNotNull(resultado.getData());

        assertEquals("Programacion Test actualizado", resultado.getData().getNombre());
        assertEquals("Curso creado para test, actulizado", resultado.getData().getDescripcion());
        assertEquals(true, resultado.getData().getEstado());
        assertEquals(999999, resultado.getData().getValor());

        

        
    }

    @Test
    @DisplayName("Debe listar los cursos creados")
    void listar(){

        Curso curso1 = new Curso();
        curso1.setSigla("AABB123");
        curso1.setNombre("Progra para lista");
        curso1.setDescripcion("Curso creado para test de lista");
        curso1.setEstado(true);
        curso1.setValor(999999);

        Curso curso2 = new Curso();
        curso2.setSigla("AABB456");
        curso2.setNombre("Progra para lista 2");
        curso2.setDescripcion("Curso creado para test de lista 2");
        curso2.setEstado(true);
        curso2.setValor(999999);

        List<Curso> lista = new ArrayList<>();
        lista.add(curso1);
        lista.add(curso2);

        when(cursoRepository.findAll()).thenReturn(lista);

        List<Curso> resultado = cursoService.listar();

        assertEquals(2,resultado.size());
        assertEquals("AABB123", resultado.get(0).getSigla());
    }

    @Test
    @DisplayName("Debe eliminar un curso correctamente")
    void eliminarCurso(){

        when(cursoRepository.existsById("AABB123"))
        .thenReturn(true);

        doNothing().when(cursoRepository).deleteById("AABB123");        

        ApiResponse<Void> resultado = cursoService.eliminarCurso("AABB123");

        assertEquals("Curso eliminado correctamente", resultado.getMensaje());
    }

    @Test
    @DisplayName("Curso no encontrado al intentar eliminar")
    void cursoNoEncontrado(){

        when(cursoRepository.existsById("AABB123"))
        .thenReturn(false);

        ApiResponse<Void> resultado = cursoService.eliminarCurso("AABB123");

        assertEquals("Curso no encontrado", resultado.getMensaje());
        assertEquals("error", resultado.getEstado());
        assertNull(resultado.getData());
    }

    
}

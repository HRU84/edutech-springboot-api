package com.edutech.edutech;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.edutech.edutech.instructor.model.Instructor;
import com.edutech.edutech.instructor.repository.InstructorRepository;
import com.edutech.edutech.instructor.service.InstructorService;
import com.edutech.edutech.shared.model.ApiResponse;

@ExtendWith(MockitoExtension.class)
public class InstructorServiceTest {

    @Mock
    private InstructorRepository instructorRepository;

    @InjectMocks
    private InstructorService instructorService;

    @Test
    @DisplayName("Crear un instructor correctamente")
    void crearInstructor(){

        Instructor instructor = new Instructor();
        instructor.setRut("11.111.111-1");
        instructor.setMail("instructor@mail.com");
        instructor.setPass("superInstructor");
        instructor.setNombre("Antonio");
        instructor.setApellido("Banderas");
        instructor.setEstado(true);

        when(instructorRepository.existsById(instructor.getRut()))
        .thenReturn(false);

        ApiResponse<Instructor> resultado = instructorService.crearInstructor(instructor);

        assertNotNull(resultado);
        assertEquals("ok", resultado.getEstado());
        assertEquals("Instructor creado correctamente", resultado.getMensaje());
        assertEquals("superInstructor", resultado.getData().getPass());
    }

    @Test
    @DisplayName("Listar instructores correctamente")
    void listar(){

        Instructor instructor1 = new Instructor();
        instructor1.setRut("11.111.111-1");
        instructor1.setMail("instructor@mail.com");
        instructor1.setPass("superInstructor");
        instructor1.setNombre("Antonio");
        instructor1.setApellido("Banderas");
        instructor1.setEstado(true);

        Instructor instructor2 = new Instructor();
        instructor2.setRut("22.222.222-2");
        instructor2.setMail("instructo2r@mail.com");
        instructor2.setPass("superInstructor2");
        instructor2.setNombre("Antonieta");
        instructor2.setApellido("Banderassasa");
        instructor2.setEstado(false);

        List<Instructor> lista = new ArrayList<>();
        lista.add(instructor1);
        lista.add(instructor2);

        when(instructorRepository.findAll()).thenReturn(lista);

        ApiResponse<List<Instructor>> resultado = instructorService.listar();

        assertEquals("ok", resultado.getEstado());
        assertEquals("Antonieta", resultado.getData().get(1).getNombre());
        assertEquals("22.222.222-2", resultado.getData().get(1).getRut());
    }

    @Test
    @DisplayName("Debe eliminar el instructor")
    void eliminarInstructor(){

        doNothing().when(instructorRepository).deleteById("22.222.222-2");

        when(instructorRepository.existsById("22.222.222-2"))
        .thenReturn(true);

        ApiResponse<Void> resultado = instructorService.eliminarInstructor("22.222.222-2");

        assertEquals("Instructor eliminado correctamente", resultado.getMensaje());
        assertEquals("ok", resultado.getEstado());
    }
    
    

}

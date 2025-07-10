package com.edutech.edutech;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.edutech.edutech.persona.model.Persona;
import com.edutech.edutech.persona.repository.PersonaRepository;
import com.edutech.edutech.persona.service.PersonaService;
import com.edutech.edutech.usuario.model.Usuario;
import com.edutech.edutech.usuario.repository.UsuarioRepository;


// Belén Toloza

@ExtendWith(MockitoExtension.class)
class PersonaServiceTest {

    @InjectMocks
    private PersonaService personaService;

    @Mock
    private PersonaRepository personaRepository;

    @Mock
    private UsuarioRepository usuarioRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks
    }

    // Test: Almacenar persona correctamente
    @Test
    void testAlmacenarPersonaCorrectamente() {
        Persona persona = new Persona();
        persona.setRut("12345678-9");
        persona.setMail("test@mail.com");

        Usuario usuario = new Usuario();
        usuario.setMail("test@mail.com");

        when(personaRepository.existsById("12345678-9")).thenReturn(false);
        when(usuarioRepository.findById("test@mail.com")).thenReturn(Optional.of(usuario));

        String resultado = personaService.almacenar(persona);

        assertEquals("Persona almacenada correctamente", resultado);
        verify(personaRepository).save(persona);
    }

    // Test: Listar personas
    @Test
    void testListarPersonas() {
        List<Persona> personas = Arrays.asList(new Persona(), new Persona());
        when(personaRepository.findAll()).thenReturn(personas);

        List<Persona> resultado = personaService.listar();

        assertEquals(2, resultado.size());
        verify(personaRepository).findAll();
    }

    // Test: Eliminar persona existente
    @Test
    void testEliminarPersonaExistente() {
        String rut = "12345678-9";
        when(personaRepository.existsById(rut)).thenReturn(true);

        String resultado = personaService.eliminar(rut);

        assertEquals("Persona eliminada correctamente", resultado);
        verify(personaRepository).deleteById(rut);
    }
}


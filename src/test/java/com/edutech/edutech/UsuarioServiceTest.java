package com.edutech.edutech;

import java.util.List;

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

import com.edutech.edutech.usuario.model.Usuario;
import com.edutech.edutech.usuario.repository.UsuarioRepository;
import com.edutech.edutech.usuario.service.UsuarioService;

// Belén Toloza

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks
    }

    // Test para almacenar un nuevo usuario
    @Test
    public void testAlmacenarUsuarioNuevo() {
        Usuario usuario = new Usuario("correo@correo.com", "1234", true);
        when(usuarioRepository.existsById(usuario.getMail())).thenReturn(false);

        String resultado = usuarioService.almacenar(usuario);

        verify(usuarioRepository).save(usuario); // Verifica que se llamó a save()
        assertEquals("Usuario almacenado correctamente", resultado);
    }

    // Test para eliminar un usuario existente
    @Test
    public void testEliminarUsuarioExistente() {
        String mail = "correo@correo.com";
        when(usuarioRepository.existsById(mail)).thenReturn(true);

        String resultado = usuarioService.eliminar(mail);

        verify(usuarioRepository).deleteById(mail); // Verifica que se llamó a deleteById()
        assertEquals("Usuario eliminado correctamente", resultado);
    }

    // Test para listar usuarios
    @Test
    public void testListarUsuarios() {
        Usuario usuario1 = new Usuario("correo1@correo.com", "pass1", true);
        Usuario usuario2 = new Usuario("correo2@correo.com", "pass2", false);

        when(usuarioRepository.findAll()).thenReturn(List.of(usuario1, usuario2));

        var resultado = usuarioService.listar();

        assertEquals(2, resultado.size());
        assertEquals("correo1@correo.com", resultado.get(0).getMail());
        assertEquals(true, resultado.get(0).isEstado());
        assertEquals("correo2@correo.com", resultado.get(1).getMail());
        assertEquals(false, resultado.get(1).isEstado());
    }

}

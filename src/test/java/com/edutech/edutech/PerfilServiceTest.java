package com.edutech.edutech;

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

import com.edutech.edutech.perfil.model.Perfil;
import com.edutech.edutech.perfil.repository.PerfilRepository;
import com.edutech.edutech.perfil.service.PerfilService;


// Belén Toloza
@ExtendWith(MockitoExtension.class)
class PerfilServiceTest {

    @InjectMocks
    private PerfilService perfilService;

    @Mock
    private PerfilRepository perfilRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks
    }

    // Almacenar perfil correctamente
    @Test
    void testAlmacenarPerfilNuevo() {
        Perfil perfil = new Perfil();
        perfil.setTag("DEV");

        when(perfilRepository.existsById("DEV")).thenReturn(false);

        String resultado = perfilService.almacenar(perfil);

        assertEquals("Perfil almacenado correctamente", resultado);
        verify(perfilRepository).save(perfil);
    }

    // Actualizar perfil existente
    @Test
    void testActualizarPerfilExistente() {
        Perfil perfil = new Perfil();
        perfil.setTag("QA");

        Perfil existente = new Perfil();
        existente.setTag("DEV");

        when(perfilRepository.existsById("DEV")).thenReturn(true);
        when(perfilRepository.findById("DEV")).thenReturn(Optional.of(existente));

        String resultado = perfilService.actualizar("DEV", perfil);

        assertEquals("Perfil actualizado correctamente", resultado);
        assertEquals("QA", existente.getTag());
        verify(perfilRepository).save(existente);
    }

}

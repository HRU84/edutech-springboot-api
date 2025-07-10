package com.edutech.edutech;
import java.util.Arrays;
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

import com.edutech.edutech.preferencia.model.Preferencia;
import com.edutech.edutech.preferencia.repository.PreferenciaRepository;
import com.edutech.edutech.preferencia.service.PreferenciaService;


@ExtendWith(MockitoExtension.class)
class PreferenciaServiceTest {

    @InjectMocks
    private PreferenciaService preferenciaService;

    @Mock
    private PreferenciaRepository preferenciaRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks
    }

    // Almacenar una preferencia
    @Test
    void testAlmacenarPreferenciaCorrectamente() {
        Preferencia preferencia = new Preferencia();
        preferencia.setDescripcion("Matemáticas");

        when(preferenciaRepository.existsByDescripcion("Matemáticas")).thenReturn(false);

        String resultado = preferenciaService.almacenar(preferencia);

        assertEquals("Preferencia almacenada correctamente", resultado);
        verify(preferenciaRepository).save(preferencia);
    }

    // Listar preferencias
    @Test
    void testListarPreferencias() {
        List<Preferencia> preferencias = Arrays.asList(new Preferencia(), new Preferencia());
        when(preferenciaRepository.findAll()).thenReturn(preferencias);

        List<Preferencia> resultado = preferenciaService.listar();

        assertEquals(2, resultado.size());
        verify(preferenciaRepository).findAll();
    }
}

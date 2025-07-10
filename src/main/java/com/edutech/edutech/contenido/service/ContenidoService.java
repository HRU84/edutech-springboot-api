package com.edutech.edutech.contenido.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.edutech.contenido.dto.ContenidoDTO;
import com.edutech.edutech.contenido.model.Contenido;
import com.edutech.edutech.contenido.repository.ContenidoRepository;
import com.edutech.edutech.curso.model.Curso;
import com.edutech.edutech.curso.repository.CursoRepository;
import com.edutech.edutech.shared.model.ApiResponse;

@Service
public class ContenidoService {
    @Autowired
    private ContenidoRepository contenidoRepository;
    @Autowired
    private CursoRepository cursoRepository;

    public List<Contenido> listar(){
        return contenidoRepository.findAll();
    }

    public ApiResponse<Contenido> obtenerPorId(Long id) {
    return contenidoRepository.findById(id)
        .map(c -> new ApiResponse<>("Contenido encontrado", "ok", c))
        .orElse(new ApiResponse<>("Contenido no encontrado", "error", null));
}

    public ApiResponse<Contenido> crearContenidoDesdeDTO(ContenidoDTO dto) {
    Curso curso = cursoRepository.findById(dto.getCursoSigla())
        .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

    Contenido contenido = new Contenido();
    contenido.setTitulo(dto.getTitulo());
    contenido.setDescripcion(dto.getDescripcion());
    contenido.setEstado(dto.getEstado());
    contenido.setCurso(curso);

    Contenido guardado = contenidoRepository.save(contenido);
    return new ApiResponse<>("Contenido creado correctamente", "ok", guardado);
}

    public ApiResponse<Void> eliminarContenido(Long id) {
    if (!contenidoRepository.existsById(id)) {
        return new ApiResponse<>("Contenido no encontrado", "error", null);
    }

    contenidoRepository.deleteById(id);
    return new ApiResponse<>("Contenido eliminado correctamente", "ok", null);
}
}
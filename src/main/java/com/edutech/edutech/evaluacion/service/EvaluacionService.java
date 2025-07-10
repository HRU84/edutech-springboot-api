package com.edutech.edutech.evaluacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.edutech.curso.model.Curso;
import com.edutech.edutech.curso.repository.CursoRepository;
import com.edutech.edutech.evaluacion.dto.EvaluacionDTO;
import com.edutech.edutech.evaluacion.model.Evaluacion;
import com.edutech.edutech.evaluacion.repository.EvaluacionRepository;
import com.edutech.edutech.shared.model.ApiResponse;

@Service
public class EvaluacionService {
    @Autowired
    private EvaluacionRepository evaluacionRepository;
    @Autowired
    private CursoRepository cursoRepository;

    public List<Evaluacion> listar(){
        return evaluacionRepository.findAll();
    }

    public ApiResponse<Evaluacion> obtenerPorId(Long id) {
    return evaluacionRepository.findById(id)
        .map(e -> new ApiResponse<>("Evaluación encontrada", "ok", e))
        .orElse(new ApiResponse<>("Evaluación no encontrada", "error", null));
}

    public ApiResponse<Evaluacion> crearEvaluacionDesdeDTO(EvaluacionDTO dto) {
    Curso curso = cursoRepository.findById(dto.getCursoSigla())
        .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

    Evaluacion evaluacion = new Evaluacion();
    evaluacion.setNombre(dto.getNombre());
    evaluacion.setCurso(curso);

    Evaluacion creada = evaluacionRepository.save(evaluacion);
    return new ApiResponse<>("Evaluación creada correctamente", "ok", creada);
}

    public ApiResponse<Void> eliminarEvaluacion(Long id) {
    if (!evaluacionRepository.existsById(id)) {
        return new ApiResponse<>("Evaluación no encontrada", "error", null);
    }
    evaluacionRepository.deleteById(id);
    return new ApiResponse<>("Evaluación eliminada correctamente", "ok", null);
}
}

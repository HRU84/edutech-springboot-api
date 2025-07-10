package com.edutech.edutech.resultado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.edutech.evaluacion.model.Evaluacion;
import com.edutech.edutech.evaluacion.repository.EvaluacionRepository;
import com.edutech.edutech.resultado.dto.ResultadoEvaluacionDTO;
import com.edutech.edutech.resultado.model.Resultado_Evaluacion;
import com.edutech.edutech.resultado.repository.ResultadoEvaluacionRepository;
import com.edutech.edutech.usuario.model.UsuarioCurso;
import com.edutech.edutech.usuario.repository.UsuarioCursoRepository;

@Service
public class ResultadoEvaluacionService {

    @Autowired
    private UsuarioCursoRepository usuarioCursoRepository;

    @Autowired
    private EvaluacionRepository evaluacionRepository;

    @Autowired
    private ResultadoEvaluacionRepository resultadoEvaluacionRepository;

    public Resultado_Evaluacion crear(ResultadoEvaluacionDTO dto) {
        UsuarioCurso usuarioCurso = usuarioCursoRepository.findById(dto.getUsuarioCursoId())
        .orElseThrow(() -> new RuntimeException("UsuarioCurso no encontrado"));

        Evaluacion evaluacion = evaluacionRepository.findById(dto.getEvaluacionId())
            .orElseThrow(() -> new RuntimeException("Evaluacion no encontrada"));

        Resultado_Evaluacion resultado = new Resultado_Evaluacion();
        resultado.setUsuarioCursoId(usuarioCurso);
        resultado.setEvaluacionId(evaluacion);
        resultado.setCalificacion(dto.getCalificacion());

        return resultadoEvaluacionRepository.save(resultado);
    }

    public List<Resultado_Evaluacion> listar() {
        return resultadoEvaluacionRepository.findAll();
    }
}

package com.edutech.edutech.resultado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.edutech.resultado.dto.ResultadoEvaluacionDTO;
import com.edutech.edutech.resultado.model.Resultado_Evaluacion;
import com.edutech.edutech.resultado.service.ResultadoEvaluacionService;

@RestController
@RequestMapping("/resultados")
public class ResultadoEvaluacionController {

    @Autowired
    private ResultadoEvaluacionService resultadoEvaluacionService;

    @PostMapping
    public Resultado_Evaluacion crear(@RequestBody ResultadoEvaluacionDTO dto) {
        return resultadoEvaluacionService.crear(dto);
    }

    @GetMapping
    public List<Resultado_Evaluacion> listar() {
        return resultadoEvaluacionService.listar();
    }
}

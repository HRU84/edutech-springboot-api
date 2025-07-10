package com.edutech.edutech.evaluacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.edutech.evaluacion.dto.EvaluacionDTO;
import com.edutech.edutech.evaluacion.model.Evaluacion;
import com.edutech.edutech.evaluacion.service.EvaluacionService;
import com.edutech.edutech.shared.model.ApiResponse;

@RestController
@RequestMapping("/evaluaciones")
public class EvaluacionController {

    @Autowired
    private EvaluacionService evaluacionService;

    @PostMapping
    public ResponseEntity<ApiResponse<Evaluacion>> crearEvaluacion(@RequestBody EvaluacionDTO dto) {
        ApiResponse<Evaluacion> respuesta = evaluacionService.crearEvaluacionDesdeDTO(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
    }

    @GetMapping
    public List<Evaluacion> listarEvaluaciones() {
        return evaluacionService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Evaluacion>> obtenerEvaluacion(@PathVariable Long id) {
        ApiResponse<Evaluacion> respuesta = evaluacionService.obtenerPorId(id);
        if ("ok".equals(respuesta.getEstado())) {
            return ResponseEntity.ok(respuesta);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> eliminarEvaluacion(@PathVariable Long id) {
        ApiResponse<Void> respuesta = evaluacionService.eliminarEvaluacion(id);
        if ("ok".equals(respuesta.getEstado())) {
            return ResponseEntity.ok(respuesta);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
        }
    }
}

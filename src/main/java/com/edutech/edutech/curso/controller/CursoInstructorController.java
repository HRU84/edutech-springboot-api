package com.edutech.edutech.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.edutech.curso.model.Curso_Instructor;
import com.edutech.edutech.curso.service.CursoInstructorService;
import com.edutech.edutech.shared.model.ApiResponse;

@RestController
@RequestMapping("/curso-instructor")
public class CursoInstructorController {

    @Autowired
    private CursoInstructorService cursoInstructorService;

    @PostMapping
    public ResponseEntity<ApiResponse<Curso_Instructor>> asignarCursoAInstructor(
        @RequestParam String cursoSigla,
        @RequestParam String instructorRut) {

    ApiResponse<Curso_Instructor> respuesta = cursoInstructorService.asignarCurso(cursoSigla, instructorRut);

    switch (respuesta.getEstado()) {
        case "ok":
            return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
        case "existe":
            return ResponseEntity.status(HttpStatus.CONFLICT).body(respuesta);
        case "error":
        default:
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
    }
}

    @GetMapping
    public List<Curso_Instructor> listarAsignaciones() {
        return cursoInstructorService.listarAsignaciones();
    }
}
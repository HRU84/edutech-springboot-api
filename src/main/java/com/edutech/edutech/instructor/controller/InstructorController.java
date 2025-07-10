package com.edutech.edutech.instructor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.edutech.instructor.model.Instructor;
import com.edutech.edutech.instructor.service.InstructorService;
import com.edutech.edutech.shared.model.ApiResponse;

@RestController
@RequestMapping("/instructores")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @PostMapping
    public ResponseEntity<ApiResponse<Instructor>> crearInstructor(@RequestBody Instructor instructor) {
        ApiResponse<Instructor> respuesta = instructorService.crearInstructor(instructor);

        return switch (respuesta.getEstado()) {
            case "ok" -> ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
            case "existe" -> ResponseEntity.status(HttpStatus.CONFLICT).body(respuesta);
            default -> ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
        };
    }

    @GetMapping
    public ResponseEntity<ApiResponse<?>> listarInstructores() {
        ApiResponse<?> respuesta = instructorService.listar();
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/{rut}")
    public ResponseEntity<ApiResponse<Instructor>> obtenerPorRut(@PathVariable String rut) {
        ApiResponse<Instructor> respuesta = instructorService.obtenerPorRut(rut);

        return switch (respuesta.getEstado()) {
            case "ok" -> ResponseEntity.ok(respuesta);
            default -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
        };
    }

    @PutMapping("/{rut}")
    public ResponseEntity<ApiResponse<Instructor>> actualizarInstructor(
            @PathVariable String rut,
            @RequestBody Instructor nuevosDatos) {

        ApiResponse<Instructor> respuesta = instructorService.actualizarInstructor(rut, nuevosDatos);

        return switch (respuesta.getEstado()) {
            case "ok" -> ResponseEntity.ok(respuesta);
            default -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
        };
    }

    @DeleteMapping("/{rut}")
    public ResponseEntity<ApiResponse<Void>> eliminarInstructor(@PathVariable String rut) {
        ApiResponse<Void> respuesta = instructorService.eliminarInstructor(rut);

        return switch (respuesta.getEstado()) {
            case "ok" -> ResponseEntity.ok(respuesta);
            default -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
        };
    }
}

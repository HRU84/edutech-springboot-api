package com.edutech.edutech.contenido.controller;

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

import com.edutech.edutech.contenido.dto.ContenidoDTO;
import com.edutech.edutech.contenido.model.Contenido;
import com.edutech.edutech.contenido.service.ContenidoService;
import com.edutech.edutech.shared.model.ApiResponse;




@RestController
@RequestMapping("/contenidos")
public class ContenidoController {

    @Autowired
    private ContenidoService contenidoService;

    @PostMapping
    public ResponseEntity<ApiResponse<Contenido>> crearContenido(@RequestBody ContenidoDTO dto) {
    ApiResponse<Contenido> respuesta = contenidoService.crearContenidoDesdeDTO(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
}
    @GetMapping
    public List<Contenido> listarContenidos() {
        return contenidoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Contenido>> obtenerContenido(@PathVariable Long id) {
        ApiResponse<Contenido> respuesta = contenidoService.obtenerPorId(id);
        if ("ok".equals(respuesta.getEstado())) {
            return ResponseEntity.ok(respuesta);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> eliminarContenido(@PathVariable Long id) {
        ApiResponse<Void> respuesta = contenidoService.eliminarContenido(id);
        if ("ok".equals(respuesta.getEstado())) {
            return ResponseEntity.ok(respuesta);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
        }
    }
}
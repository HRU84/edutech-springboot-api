package com.edutech.edutech.curso.controller;

import java.util.List;
import java.util.Optional;

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

import com.edutech.edutech.curso.dto.CursoDTO;
import com.edutech.edutech.curso.model.Curso;
import com.edutech.edutech.curso.service.CursoService;
import com.edutech.edutech.shared.model.ApiResponse;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private  CursoService cursoService;

    @GetMapping
    public List<Curso> listar(){
        return cursoService.listar();
    }

    @GetMapping ("/{sigla}")
    public Optional<Curso> obtenerPorSigla(@PathVariable String sigla){
        return cursoService.obtenerPorSigla(sigla);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Curso>> crearCurso(@RequestBody CursoDTO dto) {
        ApiResponse<Curso> respuesta = cursoService.crearCursoDesdeDTO(dto);

        switch (respuesta.getEstado()) {
            case "ok":
                return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
            case "existe":
                return ResponseEntity.status(HttpStatus.CONFLICT).body(respuesta);
            default:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
        }
    }
    

    @PutMapping("/{sigla}")
    public ResponseEntity<ApiResponse<Curso>> actualizarCurso(@PathVariable String sigla, @RequestBody CursoDTO dto) {
    ApiResponse<Curso> respuesta = cursoService.actualizarCurso(sigla, dto);

    if ("ok".equals(respuesta.getEstado())) {
        return ResponseEntity.ok(respuesta);
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
    }
    }

    @DeleteMapping("/{sigla}")
    public ResponseEntity<ApiResponse<Void>> eliminarCurso(@PathVariable String sigla) {
    ApiResponse<Void> respuesta = cursoService.eliminarCurso(sigla);

    if ("ok".equals(respuesta.getEstado())) {
        return ResponseEntity.ok(respuesta);
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
    }
}

}

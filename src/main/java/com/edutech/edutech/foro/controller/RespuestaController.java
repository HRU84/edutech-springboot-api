package com.edutech.edutech.foro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.edutech.edutech.foro.model.Respuesta;
import com.edutech.edutech.foro.service.RespuestaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/respuestas") 
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;

    //almacenar una respuesta
    @PostMapping
    public String almacenarRespuesta(@RequestBody Respuesta respuesta) {
        return respuestaService.almacenar(respuesta);
    }

    //listar  respuestas
    @GetMapping
    public List<Respuesta> listarRespuestas() {
        return respuestaService.listarRespuestas();
    }

    //eliminar una respuesta
    @DeleteMapping("/{id}") 
    public String eliminarRespuesta(@PathVariable int id) {
        return respuestaService.eliminarRespuesta(id);
    }



}

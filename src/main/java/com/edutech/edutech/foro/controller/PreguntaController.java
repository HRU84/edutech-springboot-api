package com.edutech.edutech.foro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.edutech.foro.model.Pregunta;
import com.edutech.edutech.foro.service.PreguntaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/preguntas")
public class PreguntaController {

    @Autowired
    private PreguntaService preguntaService;

    //almacenar una pregunta
    @PostMapping
    public String almacenarPregunta(@RequestBody Pregunta pregunta) {
        return preguntaService.almacenar(pregunta);
    }


    //listar una pregunta
    @GetMapping
    public List<Pregunta> listarPreguntas() {
        return preguntaService.listarPreguntas();
    }


    //eliminar una pregunta
    @DeleteMapping("/{id}")
    public String eliminarPregunta(@PathVariable Integer id) {
        return preguntaService.eliminarPregunta(id);
    }

}

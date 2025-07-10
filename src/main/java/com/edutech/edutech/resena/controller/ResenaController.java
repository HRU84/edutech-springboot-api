package com.edutech.edutech.resena.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.edutech.resena.model.Resena;
import com.edutech.edutech.resena.service.ResenaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/resenas")
public class ResenaController {

   @Autowired
   private ResenaService resenaService;

    // Almacenar una reseña
   @PostMapping
    public String almacenar(@RequestBody Resena resena) {
        return resenaService.almacenar(resena);
    }
    
    // Listar todas las reseñas
    @GetMapping
    public List<Resena> listar() {
        return resenaService.listar();
    }
    
    // Eliminar una reseña
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return resenaService.eliminar(id);
    }

}





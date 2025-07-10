package com.edutech.edutech.persona.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.edutech.persona.model.Persona;
import com.edutech.edutech.persona.repository.PersonaRepository;
import com.edutech.edutech.usuario.model.Usuario;
import com.edutech.edutech.usuario.repository.UsuarioRepository;


@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Almacenar persona
    public String almacenar(Persona persona) {

        if (personaRepository.existsById(persona.getRut())) {
            return "La persona ya existe";
        }
        if (persona.getMail() == null) {
            return "Error: Debes ingresar un mail";
        }
        Usuario usuario = usuarioRepository.findById(persona.getMail()).orElse(null);
        if (usuario == null) {
            return "Error: El usuario no existe. Debes crear el usuario primero.";
        }
        if (!usuario.getMail().equals(persona.getMail())) {
            return "Error: El mail de la persona y el usuario no coinciden";
        }
        personaRepository.save(persona);
        return "Persona almacenada correctamente";
    }

    // Listar personas
    public List<Persona> listar() {
        return personaRepository.findAll();
    }

    // Actualizar persona
    public String actualizar(String rut, Persona persona) {
        if (!personaRepository.existsById(rut)) {
            return "Error: La persona no existe";
        }
        Persona personaExistente = personaRepository.findById(rut).get();
        personaExistente.setMail(persona.getMail());
        personaExistente.setNombre(persona.getNombre());
        personaExistente.setApellido(persona.getApellido());
        // Agrega aquí otros campos si existen

        personaRepository.save(personaExistente);
        return "Persona actualizada correctamente";
    }

    // Eliminar persona
    public String eliminar(String rut) {
        if (!personaRepository.existsById(rut)) {
            return "Error: La persona no existe";
        }
        personaRepository.deleteById(rut);
        return "Persona eliminada correctamente";
    }
}
package com.edutech.edutech.perfil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.edutech.perfil.model.Perfil;
import com.edutech.edutech.perfil.repository.PerfilRepository;


@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    // Almacenar perfil
    public String almacenar(Perfil perfil) {
        if (!perfilRepository.existsById(perfil.getTag())) {
            perfilRepository.save(perfil);
            return "Perfil almacenado correctamente";
        }
        return "El perfil ya existe";
    }

    // Listar perfiles
    public List<Perfil> listar() {
        return perfilRepository.findAll();
    }

    // Buscar por nombre
    public Perfil buscarPorNombre(String nombre) {
        return perfilRepository.findByNombre(nombre);
    }

    // Actualizar perfil por tag
    public String actualizar(String tag, Perfil perfil) {
        if (!perfilRepository.existsById(tag)) {
            return "Error: El perfil no existe";
        }
        Perfil perfilExistente = perfilRepository.findById(tag).get();
        perfilExistente.setTag(perfil.getTag());
        perfilRepository.save(perfilExistente);
        return "Perfil actualizado correctamente";
    }

    // Actualizar perfil por nombre
    public String actualizarPorNombre(String nombre, Perfil perfil) {
        Perfil perfilExistente = perfilRepository.findByNombre(nombre);
        if (perfilExistente == null) {
            return "Error: El perfil no existe";
        }
        perfilExistente.setNombre(perfil.getNombre());
        perfilRepository.save(perfilExistente);
        return "Perfil actualizado correctamente";
    }

    // Eliminar perfil por tag
    public String eliminar(String tag) {
        if (!perfilRepository.existsById(tag)) {
            return "Error: El perfil no existe";
        }
        perfilRepository.deleteById(tag);
        return "Perfil eliminado correctamente";
    }

    // Eliminar perfil por nombre
    public String eliminarPorNombre(String nombre) {
        Perfil perfil = perfilRepository.findByNombre(nombre);
        if (perfil == null) {
            return "Error: El perfil no existe";
        }
        perfilRepository.delete(perfil);
        return "Perfil eliminado correctamente";
    }
}
package com.edutech.edutech.preferencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.edutech.preferencia.model.Preferencia;
import com.edutech.edutech.preferencia.repository.PreferenciaRepository;


@Service
public class PreferenciaService {

    @Autowired
    private PreferenciaRepository preferenciaRepository;

    // Almacenar preferencia
    public String almacenar(Preferencia preferencia) {
        if (!preferenciaRepository.existsByDescripcion(preferencia.getDescripcion())) {
            preferenciaRepository.save(preferencia);
            return "Preferencia almacenada correctamente";
        }
        return "La preferencia ya existe";
    }

    // Listar preferencias
    public List<Preferencia> listar() {
        return preferenciaRepository.findAll();
    }

    // Actualizar preferencia
    public String actualizar(String descripcion, Preferencia preferencia) {
        Preferencia pref = preferenciaRepository.findByDescripcion(descripcion);
        if (pref == null) {
            return "Error: La preferencia no existe";
        }
        pref.setDescripcion(preferencia.getDescripcion());
        preferenciaRepository.save(pref);
        return "Preferencia actualizada correctamente";
    }

    // Eliminar preferencia
    public String eliminar(String descripcion) {
        Preferencia pref = preferenciaRepository.findByDescripcion(descripcion);
        if (pref == null) {
            return "Error: La preferencia no existe";
        }
        preferenciaRepository.delete(pref);
        return "Preferencia eliminada correctamente";
    }
}

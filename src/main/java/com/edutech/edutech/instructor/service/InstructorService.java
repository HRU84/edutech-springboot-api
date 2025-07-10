package com.edutech.edutech.instructor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.edutech.shared.model.ApiResponse;
import com.edutech.edutech.instructor.model.Instructor;
import com.edutech.edutech.instructor.repository.InstructorRepository;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    public ApiResponse<Instructor> crearInstructor(Instructor instructor) {
        if (instructorRepository.existsById(instructor.getRut())) {
            return new ApiResponse<>("El instructor ya existe", "existe", null);
        }

        Instructor creado = instructorRepository.save(instructor);
        return new ApiResponse<>("Instructor creado correctamente", "ok", creado);
    }

    public ApiResponse<List<Instructor>> listar() {
        List<Instructor> instructores = instructorRepository.findAll();
        return new ApiResponse<>("Lista de instructores obtenida", "ok", instructores);
    }

    public ApiResponse<Instructor> obtenerPorRut(String rut) {
        Optional<Instructor> instructor = instructorRepository.findById(rut);

        if (instructor.isPresent()) {
            return new ApiResponse<>("Instructor encontrado", "ok", instructor.get());
        } else {
            return new ApiResponse<>("Instructor no encontrado", "error", null);
        }
    }

    public ApiResponse<Instructor> actualizarInstructor(String rut, Instructor nuevosDatos) {
        Optional<Instructor> instructorOpt = instructorRepository.findById(rut);

        if (instructorOpt.isEmpty()) {
            return new ApiResponse<>("Instructor no encontrado", "error", null);
        }

        Instructor instructor = instructorOpt.get();
        instructor.setNombre(nuevosDatos.getNombre());
        instructor.setApellido(nuevosDatos.getApellido());
        instructor.setMail(nuevosDatos.getMail());
        instructor.setPass(nuevosDatos.getPass());
        instructor.setEstado(nuevosDatos.getEstado());

        Instructor actualizado = instructorRepository.save(instructor);
        return new ApiResponse<>("Instructor actualizado correctamente", "ok", actualizado);
    }

    public ApiResponse<Void> eliminarInstructor(String rut) {
        if (!instructorRepository.existsById(rut)) {
            return new ApiResponse<>("Instructor no encontrado", "error", null);
        }

        instructorRepository.deleteById(rut);
        return new ApiResponse<>("Instructor eliminado correctamente", "ok", null);
    }
}

package com.edutech.edutech.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.edutech.curso.model.Curso;
import com.edutech.edutech.curso.model.CursoInstructorId;
import com.edutech.edutech.curso.model.Curso_Instructor;
import com.edutech.edutech.curso.repository.CursoInstructorRepository;
import com.edutech.edutech.curso.repository.CursoRepository;
import com.edutech.edutech.instructor.model.Instructor;
import com.edutech.edutech.instructor.repository.InstructorRepository;
import com.edutech.edutech.shared.model.ApiResponse;


@Service
public class CursoInstructorService {

    @Autowired
    private CursoInstructorRepository cursoInstructorRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    public ApiResponse<Curso_Instructor> asignarCurso(String cursoSigla, String instructorRut) {

    cursoSigla = cursoSigla.trim().toUpperCase();
    instructorRut = instructorRut.trim();

    CursoInstructorId id = new CursoInstructorId(cursoSigla, instructorRut);

    if (cursoInstructorRepository.existsById(id)) {
        return new ApiResponse<>("La asignación ya existe", "existe", null);
    }

    Optional<Curso> cursoOpt = cursoRepository.findById(cursoSigla);
    Optional<Instructor> instructorOpt = instructorRepository.findById(instructorRut);

    System.out.println("Curso encontrado: " + cursoOpt);
    System.out.println("Instructor encontrado: " + instructorOpt);

    if (cursoOpt.isPresent() && instructorOpt.isPresent()) {
        Curso_Instructor nuevo = new Curso_Instructor(cursoOpt.get(), instructorOpt.get());
        Curso_Instructor guardado = cursoInstructorRepository.save(nuevo);

        System.out.println("Curso o instructor no encontrado");
        return new ApiResponse<>("Asignación realizada exitosamente", "ok", guardado);
    }

    return new ApiResponse<>("Curso o instructor no encontrado", "error", null);
    }

    public List<Curso_Instructor> listarAsignaciones() {
        return cursoInstructorRepository.findAll();
    }
}

package com.edutech.edutech.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.edutech.curso.dto.CursoDTO;
import com.edutech.edutech.curso.model.Curso;
import com.edutech.edutech.curso.repository.CursoRepository;
import com.edutech.edutech.shared.model.ApiResponse;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;


    //Crear curso con CursoDTO
    public ApiResponse<Curso> crearCursoDesdeDTO (CursoDTO dto){

        if (cursoRepository.existsById(dto.getSigla())){
            return new ApiResponse<>("El curso "+dto.getSigla() +" ya existe", "existe", null);
        }
        Curso curso = new Curso();
        curso.setSigla(dto.getSigla());
        curso.setNombre(dto.getNombre());
        curso.setDescripcion(dto.getDescripcion());
        curso.setEstado(dto.getEstado());
        curso.setValor(dto.getValor());

        Curso guardado = cursoRepository.save(curso);
        return new ApiResponse<>("Curso creado correctamente", "ok", guardado);
    }

    //PUT
    public ApiResponse<Curso> actualizarCurso(String sigla, CursoDTO dto) {
    Optional<Curso> cursoOpt = cursoRepository.findById(sigla);

    if (cursoOpt.isEmpty()) {
        return new ApiResponse<>("Curso no encontrado", "error", null);
    }

    Curso curso = cursoOpt.get();
    curso.setNombre(dto.getNombre());
    curso.setDescripcion(dto.getDescripcion());
    curso.setEstado(dto.getEstado());
    curso.setValor(dto.getValor());

    Curso actualizado = cursoRepository.save(curso);
    return new ApiResponse<>("Curso actualizado correctamente", "ok", actualizado);
    }

    // Listar todos los cursos
    public List<Curso> listar() {
        return cursoRepository.findAll();
    }

    //BUSCAR POR SIGLA
    public Optional<Curso> obtenerPorSigla (String sigla){
        return cursoRepository.findById(sigla);
    }

    //ELIMINAR
    public ApiResponse<Void> eliminarCurso(String sigla) {
    if (!cursoRepository.existsById(sigla)) {
        return new ApiResponse<>("Curso no encontrado", "error", null);
    }

    cursoRepository.deleteById(sigla);
    return new ApiResponse<>("Curso eliminado correctamente", "ok", null);
}

}    
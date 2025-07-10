package com.edutech.edutech.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.edutech.curso.model.CursoInstructorId;
import com.edutech.edutech.curso.model.Curso_Instructor;

public interface CursoInstructorRepository extends JpaRepository<Curso_Instructor, CursoInstructorId> {

}

package com.edutech.edutech.instructor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.edutech.instructor.model.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, String> {

}

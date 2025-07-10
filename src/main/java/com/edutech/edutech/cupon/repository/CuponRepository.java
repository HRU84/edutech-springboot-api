package com.edutech.edutech.cupon.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.edutech.cupon.model.Cupon;


public interface CuponRepository extends JpaRepository<Cupon, String> {

    Optional<Cupon> findByCodigo(String codigo); 

    Optional<Cupon> deleteByCodigo(String codigo);
}

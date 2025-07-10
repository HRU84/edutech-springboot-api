package com.edutech.edutech.pago.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.edutech.pago.model.Tarjeta;

public interface TarjetaRepository extends JpaRepository<Tarjeta, Integer> {
    
 boolean existsByNumero(String numero);
 
}

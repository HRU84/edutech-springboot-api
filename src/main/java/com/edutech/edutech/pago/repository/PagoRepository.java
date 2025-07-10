package com.edutech.edutech.pago.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.edutech.pago.model.Pago;

public interface PagoRepository extends JpaRepository<Pago, Integer> {
   
    List<Pago> findByTarjetaUsuarioMail(String mail);
}

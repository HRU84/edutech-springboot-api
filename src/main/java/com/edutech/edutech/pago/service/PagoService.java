package com.edutech.edutech.pago.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edutech.edutech.pago.model.Pago;
import com.edutech.edutech.pago.repository.PagoRepository;
import com.edutech.edutech.pago.repository.TarjetaRepository;

@Service
public class PagoService {


    @Autowired 
    private PagoRepository pagoRepository;

    @Autowired
    private TarjetaRepository tarjetaRepository;
    

    //almacenar un pago
    public String almacenar(Pago pago) {
     if  (pago.getTarjeta() != null && tarjetaRepository.existsById(pago.getTarjeta().getId())) {
        pagoRepository.save(pago);
            return "Pago almacenado con éxito";
        } else {
            return "Tarjeta no encontrada, no se puede almacenar el pago";
        }
    }


    //obtener todos los pagos 
    public List<Pago> listar() {
        return pagoRepository.findAll();
    }

    //obtener pagos por usuario
    public List<Pago> listarPorUsuario(String usuarioMail) {
    return pagoRepository.findByTarjetaUsuarioMail(usuarioMail);
}


}

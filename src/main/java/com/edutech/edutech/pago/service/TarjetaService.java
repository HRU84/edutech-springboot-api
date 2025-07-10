package com.edutech.edutech.pago.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.edutech.pago.dto.TarjetaDTO;
import com.edutech.edutech.pago.model.Tarjeta;
import com.edutech.edutech.pago.repository.TarjetaRepository;


@Service
public class TarjetaService {

    @Autowired
    private TarjetaRepository tarjetaRepository;

    //almacenar una tarjeta
    public String almacenar(Tarjeta tarjeta) {
      // si ya existe otra con el mismo número
      if (tarjetaRepository.existsByNumero(tarjeta.getNumero())) {
          return "La tarjeta ya existe";
      }
      tarjetaRepository.save(tarjeta);
      return "Tarjeta almacenada con éxito";
  }

    //listar todas las tarjetas
    public List <TarjetaDTO> listarTarjetas() {
        
        List<Tarjeta> tarjetas = tarjetaRepository.findAll();
        
        List<TarjetaDTO> tarjetaDTOs = new ArrayList<>();

        for (Tarjeta tarjeta : tarjetas) {
            TarjetaDTO dto = new TarjetaDTO(
                tarjeta.getId(),
                tarjeta.getNombreTitular(),
                tarjeta.getTipo(),
                tarjeta.getBanco()
            );
            tarjetaDTOs.add(dto);
        }

        return tarjetaDTOs;
    }
    
    //eliminar una tarjeta
    public String eliminarTarjeta(int id) {
        if (tarjetaRepository.existsById(id)) {
            tarjetaRepository.deleteById(id);
            return "Tarjeta eliminada con éxito";
        } else {
            return "Tarjeta no encontrada. No se ha podido eliminar";
        }
    }
    
}
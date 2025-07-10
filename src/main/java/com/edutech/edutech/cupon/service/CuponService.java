package com.edutech.edutech.cupon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.edutech.cupon.dto.CuponDTO;
import com.edutech.edutech.cupon.model.Cupon;
import com.edutech.edutech.cupon.repository.CuponRepository;
import com.edutech.edutech.shared.model.ApiResponse;

@Service
public class CuponService {
    @Autowired
    private CuponRepository cuponRepository;

    //GET
    public List<Cupon> listar(){
        return cuponRepository.findAll();
    }

    //GET POR CODIGO
    public ApiResponse<Cupon> obtenerPorCodigo(String codigo){
        return cuponRepository.findById(codigo)
        .map(e -> new ApiResponse<>("Cupon encontrado", "ok", e))
        .orElse(new ApiResponse<>("Cupon no encontrado", "error", null));
    }

    //POST
    public ApiResponse<Cupon> crearCupon(CuponDTO dto) {
    Optional<Cupon> existente = cuponRepository.findByCodigo(dto.getCodigo());

    if (existente.isPresent()) {
        return new ApiResponse<>("Ya existe un cupón con ese código", "error", null);
    }

    Cupon nuevo = new Cupon();
    nuevo.setCodigo(dto.getCodigo());
    nuevo.setPorcentaje_descuento(dto.getPorcentaje_descuento());

    Cupon guardado = cuponRepository.save(nuevo);
    return new ApiResponse<>("Cupón creado correctamente", "ok", guardado);
}

    //DELETE
    public ApiResponse<Cupon> eliminarCupon(String codigo){
        if (!cuponRepository.existsById(codigo)){
            return new ApiResponse<>("Cupon no encontrado", "ok",null);
        }
        
        cuponRepository.deleteById(codigo);
            return new ApiResponse<>("Cupon eliminado correctamente", "ok",null);
    }

    //PUT
    public ApiResponse<Cupon> actualizarCupon(CuponDTO dto){
        if(!cuponRepository.existsById(dto.getCodigo())){
            return new ApiResponse<>("Cupon no encontrado", "ok",null);
        }
        Cupon cuponPUT = new Cupon();
        cuponPUT.setCodigo(dto.getCodigo());
        cuponPUT.setPorcentaje_descuento(dto.getPorcentaje_descuento() );
        

        Cupon guardado = cuponRepository.save(cuponPUT);
        return new ApiResponse<>("Cupón creado correctamente", "ok", guardado);
    }
}

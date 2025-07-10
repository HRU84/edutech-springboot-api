package com.edutech.edutech.cupon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.edutech.cupon.dto.CuponDTO;
import com.edutech.edutech.cupon.model.Cupon;
import com.edutech.edutech.cupon.service.CuponService;
import com.edutech.edutech.shared.model.ApiResponse;

@RestController
@RequestMapping("/cupones")
public class cuponController {
    @Autowired
    private CuponService cuponService;

    @GetMapping
    public List<Cupon> listar(){
        return cuponService.listar();
    }

    @GetMapping("/{codigo}")
    public ApiResponse<Cupon> obtenerPorCodigo(@PathVariable String codigo){
        return cuponService.obtenerPorCodigo(codigo);
    }

    @PostMapping
    public ApiResponse<Cupon> crearCupon(@RequestBody CuponDTO cuponDTO) {
        return cuponService.crearCupon(cuponDTO);
    }

    @PutMapping
    public ApiResponse<Cupon> actualizarCupon(@RequestBody CuponDTO cuponDTO) {
        return cuponService.actualizarCupon(cuponDTO);
    }

    
    @DeleteMapping("/{codigo}")
    public ApiResponse<Cupon> eliminarCupon(@PathVariable String codigo) {
        return cuponService.eliminarCupon(codigo);
    }
}

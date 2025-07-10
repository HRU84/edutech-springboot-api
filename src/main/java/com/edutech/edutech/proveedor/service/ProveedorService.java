package com.edutech.edutech.proveedor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.edutech.edutech.proveedor.dto.ProveedorDTO;
import com.edutech.edutech.proveedor.model.Proveedor;
import com.edutech.edutech.proveedor.repository.ProveedorRepository;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    //almacenar un proveedor
    public String almacenar(ProveedorDTO proveedorDTO) {

        if(proveedorRepository.existsById(proveedorDTO.getRut())) {
            return "Proveedor ya existe";
        }

       // Proveedor proveedor = proveedorRepository.findById(proveedorDTO.getRut()).get();

        Proveedor proveedor = new Proveedor();
        proveedor.setRut(proveedorDTO.getRut());
        proveedor.setNombre(proveedorDTO.getNombre()); 
        proveedor.setDireccion(proveedorDTO.getDireccion());
        proveedor.setEmail(proveedorDTO.getEmail());
        proveedor.setDescripcion(proveedorDTO.getDescripcion());

        proveedorRepository.save(proveedor);
        return "Proveedor almacenado con éxito";

    }

    //obtener todos los proveedores
    public List<Proveedor> listar() {
        return proveedorRepository.findAll();
    }

    //actualizar un proveedor
    public String actualizar(ProveedorDTO proveedorDTO) {
        if (proveedorRepository.existsById(proveedorDTO.getRut())) {
            Proveedor proveedor = new Proveedor();
            proveedor.setRut(proveedorDTO.getRut());
            proveedor.setNombre(proveedorDTO.getNombre());
            proveedor.setDireccion(proveedorDTO.getDireccion());
            proveedor.setEmail(proveedorDTO.getEmail());
            proveedor.setDescripcion(proveedorDTO.getDescripcion());
            
            proveedorRepository.save(proveedor);
            return "Proveedor actualizado con éxito";
        } else {
            return "Proveedor no encontrado";
        }
    }

    //eliminar un proveedor
    public ResponseEntity<String> eliminar(@PathVariable String rut) {
        if (proveedorRepository.existsById(rut)) {
            proveedorRepository.deleteById(rut);
            return ResponseEntity.ok("Proveedor eliminado con éxito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("Proveedor no encontrado");
        }

    }
}

package com.edutech.edutech.proveedor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.edutech.proveedor.dto.ProveedorDTO;
import com.edutech.edutech.proveedor.model.Proveedor;
import com.edutech.edutech.proveedor.service.ProveedorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    // Almacenar un proveedor
    @PostMapping
    public String almacenar(@RequestBody ProveedorDTO proveedorDTO) { 
        return proveedorService.almacenar(proveedorDTO);
    }
    
    // Obtener todos los proveedores
    @GetMapping
    public List<Proveedor> listar() {
        return proveedorService.listar();
    }

    // Actualizar un proveedor
    @PutMapping("/actualizar") 
    public String actualizar(@RequestBody ProveedorDTO proveedorDTO) {
        return proveedorService.actualizar(proveedorDTO);
    }

    // Eliminar un proveedor
    @DeleteMapping("/{rut}")
    public ResponseEntity<String> eliminar(@PathVariable String rut) {
    return proveedorService.eliminar(rut);
}


    

}

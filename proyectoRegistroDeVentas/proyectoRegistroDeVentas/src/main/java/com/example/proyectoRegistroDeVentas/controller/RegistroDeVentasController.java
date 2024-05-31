package com.example.proyectoRegistroDeVentas.controller;

import com.example.proyectoRegistroDeVentas.Entities.RegistroDeVentas;
import com.example.proyectoRegistroDeVentas.service.RegistroDeVentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="http://localhost:5173") // es para que react acceda a nuestro servidor (backend)
@RestController
@RequestMapping(path = "api/v1/registrodeventas")
public class RegistroDeVentasController {
@Autowired
    private RegistroDeVentasService registroDeVentasService;

   @GetMapping("/findAll")
    public List<RegistroDeVentas> getAll(){
        return  registroDeVentasService.getRegistroDeVentas();

    }

    @GetMapping("/PorId/{ventaId}")
    public Optional<RegistroDeVentas> getById(@PathVariable Long ventaId ){
        return  registroDeVentasService.findById(ventaId);

    }

    @PostMapping
    public void createVenta(@RequestBody RegistroDeVentas registroDeVentas) {
        registroDeVentas.setValortotal(registroDeVentas.getCantidad() * registroDeVentas.getPrecio());
        registroDeVentasService.saveOrUpdate(registroDeVentas);
    }

    @PutMapping("/{ventaId}")
    public void updateVenta(@PathVariable Long ventaId, @RequestBody RegistroDeVentas registroDeVentas) {
        Optional<RegistroDeVentas> optionalVenta = registroDeVentasService.findById(ventaId);
        if (optionalVenta.isPresent()) {
            RegistroDeVentas existingVenta = optionalVenta.get();
            existingVenta.setPrecio(registroDeVentas.getPrecio());
            existingVenta.setCantidad(registroDeVentas.getCantidad());
            existingVenta.setMarca(registroDeVentas.getMarca());
            existingVenta.setFecha(registroDeVentas.getFecha());
            existingVenta.setValortotal(registroDeVentas.getCantidad() * registroDeVentas.getPrecio());
            registroDeVentasService.saveOrUpdate(existingVenta);
        } else {
            // Handle case where ventaId does not exist (optional)
        }
    }



    @DeleteMapping("/{registroDeVentasId}")
    public void deleteVenta(@PathVariable Long registroDeVentasId) {
        registroDeVentasService.delete(registroDeVentasId);
    }


}

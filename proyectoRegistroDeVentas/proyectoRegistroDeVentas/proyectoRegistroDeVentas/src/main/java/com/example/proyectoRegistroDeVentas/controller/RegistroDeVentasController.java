package com.example.proyectoRegistroDeVentas.controller;

import com.example.proyectoRegistroDeVentas.Entities.RegistroDeVentas;
import com.example.proyectoRegistroDeVentas.service.RegistroDeVentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins ="http://localhost:5173") // es para que react acceda a nuestro servidor (backend)
@RestController
@RequestMapping(path = "api/v1/registrodeventas")
public class RegistroDeVentasController {
@Autowired
    private RegistroDeVentasService registroDeVentasService;

   @GetMapping
    public List<RegistroDeVentas> getAll(){
        return  registroDeVentasService.getRegistroDeVentas();

    }

    @GetMapping("/PorId/{ventaId}")
    public Optional<RegistroDeVentas> getById(@PathVariable Long ventaId ){
        return  registroDeVentasService.findById(ventaId);

    }

    @PostMapping
    public void  saveUpdate(@RequestBody RegistroDeVentas registroDeVentas){

       RegistroDeVentas registroDeVentas1 = new RegistroDeVentas();
        registroDeVentas1.setPrecio(registroDeVentas.getPrecio());
        registroDeVentas1.setCantidad(registroDeVentas.getCantidad());
        registroDeVentas1.setVentaId(registroDeVentas.getVentaId());
        registroDeVentas1.setMarca(registroDeVentas.getMarca());
        registroDeVentas1.setFecha(registroDeVentas.getFecha());

        double valotTotal = registroDeVentas1.getCantidad()*registroDeVentas1.getPrecio();

        registroDeVentas1.setValortotal(valotTotal);
        registroDeVentasService.saveOrUpdate(registroDeVentas1);

    }

    @DeleteMapping("{registroDeVentasId}")
    public void  saveUpdate(@PathVariable("registroDeVentasId")Long registroDeVentasId){
        registroDeVentasService.delete(registroDeVentasId);

    }



}

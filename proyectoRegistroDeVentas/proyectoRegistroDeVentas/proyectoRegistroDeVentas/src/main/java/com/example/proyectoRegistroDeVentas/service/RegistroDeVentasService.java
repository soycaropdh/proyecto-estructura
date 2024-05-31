package com.example.proyectoRegistroDeVentas.service;

import com.example.proyectoRegistroDeVentas.Entities.RegistroDeVentas;
import com.example.proyectoRegistroDeVentas.repository.RegistroDeVentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroDeVentasService {
 @Autowired
    RegistroDeVentasRepository registroDeVentasRepository;

 // listar las ventas
  public List<RegistroDeVentas> getRegistroDeVentas(){return registroDeVentasRepository.findAll();
  }

 public Optional<RegistroDeVentas> findById(Long ventaId){
     return registroDeVentasRepository.findById(ventaId);
 }
 //guardar y editar
 public void saveOrUpdate(RegistroDeVentas registroDeVentas){
      registroDeVentasRepository.save(registroDeVentas);

 }
 // eliminar
    public void delete(Long id){
        registroDeVentasRepository.deleteById(id);

    }

}

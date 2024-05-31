package com.example.proyectoRegistroDeVentas.repository;

import com.example.proyectoRegistroDeVentas.Entities.RegistroDeVentas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// esta clase simepre entiende de jparepository y se coloca
// el nombre de la enitidad y el tipo de dato de ID

@Repository
public interface RegistroDeVentasRepository extends JpaRepository<RegistroDeVentas,Long> {



}

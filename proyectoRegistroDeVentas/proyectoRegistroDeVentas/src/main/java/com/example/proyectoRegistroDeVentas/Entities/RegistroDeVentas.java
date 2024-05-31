package com.example.proyectoRegistroDeVentas.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data //para los metodos get y set
@Entity
@Table(name= "tbla_registrodeventas")
@AllArgsConstructor // crea un contructor en el que incluye todos los campos
@NoArgsConstructor // crea un contructor sin ningun campo
public class RegistroDeVentas {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private  long ventaId;
    @NonNull
    @Column(length = 50)
private String marca;

    @NonNull
    @Column(length = 50)
    private double precio;

    @NonNull
    @Column(length = 50)
    private int cantidad;

    @NonNull
    @Column(length = 50)
    private String fecha;

    @NonNull
    @Column(length = 50)
    private double valortotal;

    public long getVentaId() {
        return ventaId;
    }

    public void setVentaId(long ventaId) {
        this.ventaId = ventaId;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getValortotal() {
        return valortotal;
    }

    public void setValortotal(double valortotal) {
        this.valortotal = valortotal;
    }
}

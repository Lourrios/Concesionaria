/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionaria;

import java.io.Serializable;

/**
 *
 * @author Lourdes
 */
public class Vehiculo implements Serializable{

    private String marca;
    private String modelo;
    private int anio;
    private String color;
    private int kilometraje;
    private EstadoVehiculo estado;
    private TipoVehiculo tipoVehiculo;
    private boolean mantenimientoRealizado;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, int anio, String color, int kilometraje, EstadoVehiculo estado, TipoVehiculo tipoVehiculo, boolean mantenimientoRealizado) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.color = color;
        this.kilometraje = kilometraje;
        this.estado = estado;
        this.tipoVehiculo = tipoVehiculo;
        this.mantenimientoRealizado = mantenimientoRealizado;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public EstadoVehiculo getEstado() {
        return estado;
    }

    public void setEstado(EstadoVehiculo estado) {
        this.estado = estado;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public boolean isMantenimientoRealizado() {
        return mantenimientoRealizado;
    }

    public void setMantenimientoRealizado(boolean mantenimientoRealizado) {
        this.mantenimientoRealizado = mantenimientoRealizado;
    }

    @Override
    public String toString() {
        return "Vehiculo" + "marca=" + marca + ", modelo=" + modelo + ", anio=" + anio + ", color=" + color + ", kilometraje=" + kilometraje + ", estado=" + estado + ", tipoVehiculo=" + tipoVehiculo + ", mantenimientoRealizado=" + mantenimientoRealizado;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionaria;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Concesionaria1 extends Concesionaria implements  Serializable {
    private List<Vehiculo> inventario = new ArrayList<>();
    private transient List<Vehiculo> colaRevisionMecanica = new ArrayList<>();

    public void agregarVehiculo(Vehiculo vehiculo) {
        inventario.add(vehiculo);
        if (vehiculo instanceof Vehiculo && !(vehiculo).isMantenimientoRealizado()) {
            colaRevisionMecanica.add(vehiculo);
        }
    }

    public ResultadoOperacion venderVehiculo(Vehiculo vehiculo) {
        if (!inventario.contains(vehiculo)) {
            return new ResultadoOperacion(EstadoOperacion.FALLIDA, "El vehículo no está en el inventario.");
        } else {
            inventario.remove(vehiculo);
            if (vehiculo instanceof Vehiculo) {
                colaRevisionMecanica.remove(vehiculo);
            }
            return new ResultadoOperacion(EstadoOperacion.EXITOSA, "VENTA EXITOSA");
        }
    }

    public ResultadoOperacion realizarMantenimiento(Vehiculo vehiculo) {
        if (vehiculo.getEstado() == EstadoVehiculo.NUEVO) {
            return new ResultadoOperacion(EstadoOperacion.FALLIDA, "No se puede realizar mantenimiento en un vehículo nuevo.");
        }
        vehiculo.setMantenimientoRealizado(true);
        return new ResultadoOperacion(EstadoOperacion.EXITOSA, "Mantenimiento realizado con exito");
    }

    public List<Vehiculo> obtenerInventario() {
        return inventario;
    }

    public List<Vehiculo> obtenerColaRevisionMecanica() {
        return colaRevisionMecanica;
    }
    
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        colaRevisionMecanica = new ArrayList<>();
    }
}

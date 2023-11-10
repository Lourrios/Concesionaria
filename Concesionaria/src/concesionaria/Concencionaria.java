/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionaria;

import java.util.List;

/**
 *
 * @author Lourdes
 */
public interface Concencionaria {
    
    void agregarVehiculo(Vehiculo vehiculo);

    ResultadoOperacion venderVehiculo(Vehiculo vehiculo);

    ResultadoOperacion realizarMantenimiento(Vehiculo vehiculo);

    List<Vehiculo> obtenerInventario();
}


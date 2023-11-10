/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionaria;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Lourdes
 */
public class Concesionaria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Concesionaria1 concesionaria = new Concesionaria1();
        Scanner scanner = new Scanner(System.in);

        while (true) {
             System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar vehículo");
            System.out.println("2. Vender vehículo");
            System.out.println("3. Realizar mantenimiento");
            System.out.println("4. Mostrar inventario");
            System.out.println("5. Mostrar cola de revisión mecánica");
            System.out.println("6. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Agregar vehículo
                    Vehiculo vehiculo = crearVehiculoDesdeEntrada(scanner);
                    concesionaria.agregarVehiculo(vehiculo);
                    System.out.println("Vehículo agregado al inventario.");
                    break;
                case 2:
                    // Vender vehículo
                    if (!concesionaria.obtenerInventario().isEmpty()) {
                        System.out.println("Ingrese el número de serie del vehículo a vender:");
                        int numeroSerie = scanner.nextInt();
                        Vehiculo vehiculoAVender = concesionaria.obtenerInventario().get(numeroSerie);
                        ResultadoOperacion resultadoVenta = concesionaria.venderVehiculo(vehiculoAVender);
                        if (resultadoVenta.getEstado() == EstadoOperacion.EXITOSA) {
                            System.out.println("Venta exitosa");
                        } else {
                            System.out.println("Error en la venta: " + resultadoVenta.getMensajeError());
                        }
                    } else {
                        System.out.println("El inventario está vacío.");
                    }
                    break;
                case 3:
                    // Realizar mantenimiento
                    if (!concesionaria.obtenerInventario().isEmpty()) {
                        System.out.println("Ingrese el número de serie del vehículo para mantenimiento:");
                        int numeroSerie = scanner.nextInt();
                        Vehiculo vehiculoMantenimiento = concesionaria.obtenerInventario().get(numeroSerie);
                        ResultadoOperacion resultadoMantenimiento = concesionaria.realizarMantenimiento(vehiculoMantenimiento);
                        if (resultadoMantenimiento.getEstado() == EstadoOperacion.EXITOSA) {
                            System.out.println("Mantenimiento realizado");
                        } else {
                            System.out.println("Error en el mantenimiento: " + resultadoMantenimiento.getMensajeError());
                        }
                    } else {
                        System.out.println("El inventario está vacío.");
                    }
                    break;
                case 4:
                    // Mostrar inventario
                    List<Vehiculo> inventario = concesionaria.obtenerInventario();
                    if (inventario.isEmpty()) {
                        System.out.println("El inventario está vacío.");
                    } else {
                        System.out.println("Inventario actual:");
                        for (int i = 0; i < inventario.size(); i++) {
                            System.out.println(i + ". " + inventario.get(i).getMarca() + " " + inventario.get(i).getModelo());
                        }
                    }
                    break;
                case 5:
                  // Mostrar cola de revisión mecánica
                    List<Vehiculo> colaMecanica = concesionaria.obtenerColaRevisionMecanica();
                    if (colaMecanica.isEmpty()) {
                        System.out.println("La cola de revisión mecánica está vacía.");
                    } else {
                        System.out.println("Cola de revisión mecánica actual:");
                        for (int i = 0; i < colaMecanica.size(); i++) {
                            System.out.println(i + ". " + colaMecanica.get(i).getMarca() + " " + colaMecanica.get(i).getModelo());
                        }
                    }
                    break;
                case 6:
                    // Salir
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    // Método para crear un vehículo a partir de la entrada del usuario
    private static Vehiculo crearVehiculoDesdeEntrada(Scanner scanner) {
        scanner.nextLine(); // Consume la nueva línea después de leer un entero

        System.out.println("Ingrese la marca del vehículo:");
        String marca = scanner.nextLine();

        System.out.println("Ingrese el modelo del vehículo:");
        String modelo = scanner.nextLine();

        System.out.println("Ingrese el año del vehículo:");
        int año = scanner.nextInt();

        System.out.println("Ingrese el estado del vehículo (1 para Nuevo, 2 para Usado):");
        int estado = scanner.nextInt();
        EstadoVehiculo estadoVehiculo = (estado == 1) ? EstadoVehiculo.NUEVO : EstadoVehiculo.USADO;

        System.out.println("¿Se ha realizado el mantenimiento en el vehículo? (true/false):");
        boolean mantenimientoRealizado = scanner.nextBoolean();

        scanner.nextLine(); // Consume la nueva línea después de leer un booleano

        System.out.println("Ingrese el color del vehículo:");
        String color = scanner.nextLine();

        System.out.println("Ingrese el tipo de carrocería del vehículo (1 para AUTOMOVIL, 2 para MOTOCICLETA, 3 para CAMIONETA):");
        int tipoCarroceria = scanner.nextInt();
        TipoVehiculo tipo = TipoVehiculo.AUTOMOVIL.CAMIONETA.MOTOCICLETA; // Valor predeterminado

        switch (tipoCarroceria) {
            case 1:
                tipo = TipoVehiculo.AUTOMOVIL;
                break;
            case 2:
                tipo = TipoVehiculo.CAMIONETA;
                break;
            case 3:
                tipo = TipoVehiculo.MOTOCICLETA;
                break;
        }

        return new Vehiculo(marca, modelo, año, color, estado, estadoVehiculo, tipo, mantenimientoRealizado);
    }
}

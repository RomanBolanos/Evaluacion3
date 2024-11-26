
package Prueba;

/**
 *
 * @author Roman 20232218172
 */
import java.util.Scanner;
import Garajes.Garaje;
import Vehiculos.*;
import Excepciones.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Garaje garaje = new Garaje("Cundinamarca", "Bogotá", "Carrera 10 #30-40", "123456789", "garaje@ejemplo.com", "Juan Pérez", 50);

        boolean salir = false;

        while (!salir) { 
            System.out.println("\n=== Menú de Gestión del Garaje ===");
            System.out.println("1. Alquilar un espacio");
            System.out.println("2. Retirar vehículo");
            System.out.println("3. Consulta de ingresos mensuales");
            System.out.println("4. Consulta proporción autos / motos");
            System.out.println("5. Listado de vehículos");
            System.out.println("6. Mostrar cuántos camiones hay por tipo");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();  

            switch (opcion) {
                case 1:
                    alquilarEspacio(garaje, scanner);  
                    break;
                case 2:
                    retirarVehiculo(garaje, scanner);  
                    break;
                case 3:
                    consultaIngresosMensuales(garaje);  
                    break;
                case 4:
                    consultaProporcionAutosMotos(garaje);  
                    break;
                case 5:
                    listadoVehiculos(garaje);  
                    break;
                case 6:
                    mostrarCamionetasPorTipo(garaje);  
                    break;
                case 7:
                    salir = true;  
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
        scanner.close();
    }

    
    public static void alquilarEspacio(Garaje garaje, Scanner scanner) {
        System.out.print("Ingrese la matrícula del vehículo: ");
        String matricula = scanner.nextLine();

 
        System.out.print("Ingrese el tipo de vehículo (1. Auto, 2. Moto, 3. Camioneta): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); 

    
        System.out.print("Ingrese la marca del vehículo: ");
        String marca = scanner.nextLine();
        System.out.print("Ingrese el precio del vehículo: ");
        double precio = scanner.nextDouble();
        System.out.print("Ingrese el cilindraje del vehículo: ");
        int cilindraje = scanner.nextInt();

        
        Vehiculo vehiculo = null;
        if (tipo == 1) {
            System.out.print("¿Tiene radio? (true/false): ");
            boolean tieneRadio = scanner.nextBoolean();
            System.out.print("¿Tiene navegador? (true/false): ");
            boolean tieneNavegador = scanner.nextBoolean();
            vehiculo = new Auto(matricula, marca, precio, cilindraje, tieneRadio, tieneNavegador);
        } else if (tipo == 2) {
            System.out.print("¿Tiene sidecar? (true/false): ");
            boolean tieneSidecar = scanner.nextBoolean();
            vehiculo = new Moto(matricula, marca, precio, cilindraje, tieneSidecar);
        } else if (tipo == 3) {
            System.out.print("Ingrese el tipo de servicio (SUV, Pickup, Carga, Otro): ");
            String tipoServicio = scanner.nextLine();
            System.out.print("Ingrese el número de pasajeros: ");
            int numeroPasajeros = scanner.nextInt();
            System.out.print("¿Tiene remolque? (true/false): ");
            boolean tieneRemolque = scanner.nextBoolean();
            vehiculo = new Camioneta(matricula, marca, precio, cilindraje, tipoServicio, numeroPasajeros, tieneRemolque);
        }

        
        try {
            if (garaje.agregarVehiculo(vehiculo)) {
                System.out.println("Vehículo agregado al garaje.");
            } else {
                System.out.println("No se pudo agregar el vehículo. El garaje está lleno.");
            }
        } catch (ExcepcionPlazasSuperadas e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

   
    public static void retirarVehiculo(Garaje garaje, Scanner scanner) {
        System.out.print("Ingrese la matrícula del vehículo a retirar: ");
        String matricula = scanner.nextLine();
        
        if (garaje.retirarVehiculo(matricula)) {
            System.out.println("Vehículo retirado del garaje.");
        } else {
            System.out.println("Vehículo no encontrado.");
        }
    }

    
    public static void consultaIngresosMensuales(Garaje garaje) {
        double ingresos = garaje.calcularIngresos();
        System.out.println("Ingresos mensuales del garaje: $" + ingresos);
    }

    
    public static void consultaProporcionAutosMotos(Garaje garaje) {
        int numAutos = garaje.calcularOcupacionPorTipoVehiculo(new Auto(null, null, 0, 0, false, false));
        int numMotos = garaje.calcularOcupacionPorTipoVehiculo(new Moto(null, null, 0, 0, false));

        System.out.println("Proporción de Autos: " + numAutos);
        System.out.println("Proporción de Motos: " + numMotos);
    }

    
    public static void listadoVehiculos(Garaje garaje) {
        Vehiculo[] vehiculos = garaje.getVehiculos();
        System.out.println("=== Listado de Vehículos en el Garaje ===");
        for (Vehiculo v : vehiculos) {
            if (v != null) {
                System.out.println("Matrícula: " + v.getPlaca() + ", Cuota Mensual: $" + v.getCuotaMesGaraje() +
                                   ", Tipo: " + v.getClass().getSimpleName());
            }
        }
    }

   
    public static void mostrarCamionetasPorTipo(Garaje garaje) {
        garaje.mostrarCamionetasPorTipo();
    }
}


